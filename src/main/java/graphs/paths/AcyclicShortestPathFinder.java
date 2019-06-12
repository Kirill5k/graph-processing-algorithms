package graphs.paths;

import graphs.datatypes.graphs.weight.EdgeWeightedGraph;
import graphs.datatypes.graphs.weight.WeightedEdge;
import graphs.topologies.DepthFirstOrderFinder;
import graphs.topologies.OrderFinder;

public class AcyclicShortestPathFinder extends ShortestPathFinder {
    private OrderFinder<WeightedEdge> orderFinder;

    public AcyclicShortestPathFinder(EdgeWeightedGraph graph, int source) {
        super(graph, source);
        orderFinder = new DepthFirstOrderFinder<>(graph);
        distanceTo[source] = INITIAL_DISTANCE;
        for (int vertex : orderFinder.order()) {
            relax(vertex);
        }
    }

    private void relax(int vertex) {
        for (WeightedEdge edge : graph.adjacentEdges(vertex)) {
            int adjacentVertex = edge.to();
            double newWeight = distanceTo[vertex] + edge.weight();
            if (distanceTo[adjacentVertex] > newWeight) {
                distanceTo[adjacentVertex] = newWeight;
                edgeTo[adjacentVertex] = edge;
            }
        }
    }
}
