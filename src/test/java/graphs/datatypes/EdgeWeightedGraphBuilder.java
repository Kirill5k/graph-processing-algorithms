package graphs.datatypes;

import graphs.datatypes.graphs.weight.EdgeWeightedGraph;
import graphs.datatypes.graphs.weight.WeightedEdge;

public class EdgeWeightedGraphBuilder {
    private EdgeWeightedGraphBuilder() {}

    public static EdgeWeightedGraph smallEdgeWeightedGraph() {
        EdgeWeightedGraph graph = new EdgeWeightedGraph(8);
        graph.add(new WeightedEdge(4, 5, 0.35));
        graph.add(new WeightedEdge(4, 7, 0.37));
        graph.add(new WeightedEdge(5, 7, 0.28));
        graph.add(new WeightedEdge(0, 7, 0.16));
        graph.add(new WeightedEdge(1, 5, 0.32));
        graph.add(new WeightedEdge(0, 4, 0.38));
        graph.add(new WeightedEdge(2, 3, 0.17));
        graph.add(new WeightedEdge(1, 7, 0.19));
        graph.add(new WeightedEdge(0, 2, 0.26));
        graph.add(new WeightedEdge(1, 2, 0.36));
        graph.add(new WeightedEdge(1, 3, 0.29));
        graph.add(new WeightedEdge(2, 7, 0.34));
        graph.add(new WeightedEdge(6, 2, 0.40));
        graph.add(new WeightedEdge(3, 6, 0.52));
        graph.add(new WeightedEdge(6, 0, 0.58));
        graph.add(new WeightedEdge(6, 4, 0.93));
        return graph;
    }
}
