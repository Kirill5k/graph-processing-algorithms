package graphs.paths;

import graphs.datatypes.graphs.weight.EdgeWeightedGraph;
import graphs.datatypes.graphs.weight.WeightedEdge;

import java.math.BigDecimal;
import java.util.LinkedList;

public class BellmanFordShortestPathFinder extends ShortestPathFinder {
    private final LinkedList<Integer> queue = new LinkedList<>();

    public BellmanFordShortestPathFinder(EdgeWeightedGraph graph, int source) {
        super(graph, source);
        distanceTo[source] = INITIAL_DISTANCE;
        queue.add(source);
        while (!queue.isEmpty()) {
            relax(queue.pollFirst());
        }
    }

    private void relax(int vertex) {
        for (WeightedEdge edge : graph.adjacentEdges(vertex)) {
            int adjacentVertex = edge.to();
            double newWeight = BigDecimal.valueOf(distanceTo[vertex]).add(BigDecimal.valueOf(edge.weight())).doubleValue();
            if (distanceTo[adjacentVertex] > newWeight) {
                distanceTo[adjacentVertex] = newWeight;
                edgeTo[adjacentVertex] = edge;
                if (!queue.contains(adjacentVertex)) {
                    queue.add(adjacentVertex);
                }
            }
        }

    }
}