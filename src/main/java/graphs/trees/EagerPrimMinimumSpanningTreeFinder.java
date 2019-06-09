package graphs.trees;

import graphs.datatypes.graphs.weight.EdgeWeightedGraph;
import graphs.datatypes.graphs.weight.WeightedEdge;
import graphs.datatypes.queues.IndexedPriorityQueue;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EagerPrimMinimumSpanningTreeFinder extends MinimumSpanningTreeFinder {
    private static final int STARTING_VERTEX = 0;
    private static final double STARTING_WEIGHT = 0;

    private final WeightedEdge[] edgeTo;
    private final double[] distTo;
    private final boolean[] marked;
    private final IndexedPriorityQueue<Integer, Double> edgeQueue = new IndexedPriorityQueue<>();

    protected EagerPrimMinimumSpanningTreeFinder(EdgeWeightedGraph graph) {
        super(graph);
        edgeTo = new WeightedEdge[graph.vertices()];
        distTo = new double[graph.vertices()];
        marked = new boolean[graph.vertices()];
        IntStream.range(0, graph.vertices()).forEach(vertex -> distTo[vertex] = Double.POSITIVE_INFINITY);

        distTo[STARTING_VERTEX] = 0;
        edgeQueue.put(STARTING_VERTEX, STARTING_WEIGHT);
        while (!edgeQueue.isEmpty()) {
            visit(edgeQueue.poll());
        }
    }

    private void visit(int vertex) {
        marked[vertex] = true;
        for (WeightedEdge edge: graph.adjacentEdges(vertex)) {
            int adjacentVertex = edge.other(vertex);
            if (!marked[adjacentVertex] && edge.weight() < distTo[adjacentVertex]) {
                edgeTo[adjacentVertex] = edge;
                distTo[adjacentVertex] = edge.weight();
                edgeQueue.put(adjacentVertex, edge.weight());
            }
        }
    }

    @Override
    public Collection<WeightedEdge> edges() {
        return Arrays.stream(edgeTo)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public double weight() {
        return Arrays.stream(edgeTo)
                .filter(Objects::nonNull)
                .mapToDouble(WeightedEdge::weight).sum();
    }
}
