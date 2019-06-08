package graphs.trees;

import graphs.datatypes.weighted.EdgeWeightedGraph;
import graphs.datatypes.weighted.WeightedEdge;

import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class KruskalMinimumSpanningTreeFinder extends MinimumSpanningTreeFinder {
    private final LinkedList<WeightedEdge> minimumSpanningTree = new LinkedList<>();
    private final PriorityQueue<WeightedEdge> priorityQueue;
    private final int[] network;

    protected KruskalMinimumSpanningTreeFinder(EdgeWeightedGraph graph) {
        super(graph);
        network = new int[graph.vertices()];
        IntStream.range(0, graph.vertices()).forEach(vertex -> network[vertex] = vertex);

        priorityQueue = new PriorityQueue<>(graph.allEdges());

        while (!priorityQueue.isEmpty() && minimumSpanningTree.size() < graph.vertices() - 1) {
            WeightedEdge edge = priorityQueue.poll();
            int vertex = edge.from();
            int adjacentVertex = edge.to();
            if (areNotConnected(vertex, adjacentVertex)) {
                connect(vertex, adjacentVertex);
                minimumSpanningTree.add(edge);
            }
        }
    }

    private void connect(int vertex, int adjacentVertex) {
        int graph1Id = network[vertex];
        int graph2Id = network[adjacentVertex];

        IntStream.range(0, network.length)
                .filter(vert -> network[vert] == graph2Id)
                .forEach(vert -> network[vert] = graph1Id);
    }

    private boolean areNotConnected(int vertex, int adjacentVertex) {
        return network[vertex] != network[adjacentVertex];
    }

    @Override
    public Collection<WeightedEdge> edges() {
        return minimumSpanningTree;
    }

    @Override
    public double weight() {
        return minimumSpanningTree.stream()
                .mapToDouble(WeightedEdge::weight)
                .sum();
    }
}
