package graphs.trees;

import graphs.datatypes.Edge;
import graphs.datatypes.weighted.EdgeWeightedGraph;
import graphs.datatypes.weighted.WeightedEdge;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EagerPrimMinimumSpanningTreeFinder extends MinimumSpanningTreeFinder {
    private static final int STARTING_VERTEX = 0;
    private static final double STARTING_WEIGHT = 0;

    private final WeightedEdge[] edgeTo;
    private final double[] distTo;
    private final boolean[] marked;
    private final Map<Integer, Double> edgeQueue = new HashMap<>();

    protected EagerPrimMinimumSpanningTreeFinder(EdgeWeightedGraph graph) {
        super(graph);
        edgeTo = new WeightedEdge[graph.vertices()];
        distTo = new double[graph.vertices()];
        marked = new boolean[graph.vertices()];
        IntStream.range(0, graph.vertices()).forEach(vertex -> distTo[vertex] = Double.POSITIVE_INFINITY);

        distTo[STARTING_VERTEX] = 0;
        edgeQueue.put(STARTING_VERTEX, STARTING_WEIGHT);
        while (!edgeQueue.isEmpty()) {
            visit(getAndDeleteMinVertexFromQueue());
        }
    }

    private void visit(int vertex) {
        marked[vertex] = true;
        for (Edge edge : graph.adjacentEdges(vertex)) {
            WeightedEdge weightedEdge = (WeightedEdge) edge;
            int adjacentVertex = weightedEdge.other(vertex);
            if (!marked[adjacentVertex] && weightedEdge.weight() < distTo[adjacentVertex]) {
                edgeTo[adjacentVertex] = weightedEdge;
                distTo[adjacentVertex] = weightedEdge.weight();
                edgeQueue.put(adjacentVertex, weightedEdge.weight());
            }
        }
    }

    private Integer getAndDeleteMinVertexFromQueue() {
        int min = edgeQueue.entrySet().stream()
                .min(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new RuntimeException("unable to find vertex"));
        edgeQueue.remove(min);
        return min;
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
