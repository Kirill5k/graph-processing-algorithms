package graphs.paths;

import graphs.datatypes.graphs.weight.EdgeWeightedGraph;
import graphs.datatypes.graphs.weight.WeightedEdge;
import graphs.datatypes.queues.IndexedPriorityQueue;

import java.math.BigDecimal;

public class DijkstraShortestPathFinder extends ShortestPathFinder {
    private final IndexedPriorityQueue<Integer, Double> priorityQueue = new IndexedPriorityQueue<>();

    public DijkstraShortestPathFinder(EdgeWeightedGraph graph, int source) {
        super(graph, source);
        distanceTo[source] = INITIAL_DISTANCE;
        priorityQueue.put(source, INITIAL_DISTANCE);
        while (!priorityQueue.isEmpty()) {
            relax(priorityQueue.poll());
        }
    }

    private void relax(int vertex) {
        for (WeightedEdge edge : graph.adjacentEdges(vertex)) {
            int adjacentVertex = edge.to();
            double newWeight = BigDecimal.valueOf(distanceTo[vertex]).add(BigDecimal.valueOf(edge.weight())).doubleValue();
            if (distanceTo[adjacentVertex] > newWeight) {
                distanceTo[adjacentVertex] = newWeight;
                edgeTo[adjacentVertex] = edge;
                priorityQueue.put(adjacentVertex, edge.weight());
            }
        }
    }

}
