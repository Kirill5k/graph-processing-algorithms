package graphs.datatypes;

import graphs.datatypes.graphs.weight.DirectedEdgeWeightedGraph;
import graphs.datatypes.graphs.weight.WeightedEdge;

public class DirectedEdgeWeightedGraphBuilder {
    private DirectedEdgeWeightedGraphBuilder() {}

    public static DirectedEdgeWeightedGraph smallDirectedEdgeWeightedGraph() {
        DirectedEdgeWeightedGraph graph = new DirectedEdgeWeightedGraph(8);
        graph.add(new WeightedEdge(4, 5, 0.35));
        graph.add(new WeightedEdge(5, 4, 0.35));
        graph.add(new WeightedEdge(4, 7, 0.37));
        graph.add(new WeightedEdge(5, 7, 0.28));
        graph.add(new WeightedEdge(7, 5, 0.28));
        graph.add(new WeightedEdge(5, 1, 0.32));
        graph.add(new WeightedEdge(0, 4, 0.38));
        graph.add(new WeightedEdge(0, 2, 0.26));
        graph.add(new WeightedEdge(7, 3, 0.39));
        graph.add(new WeightedEdge(1, 3, 0.29));
        graph.add(new WeightedEdge(2, 7, 0.34));
        graph.add(new WeightedEdge(6, 2, 0.40));
        graph.add(new WeightedEdge(3, 6, 0.52));
        graph.add(new WeightedEdge(6, 0, 0.58));
        graph.add(new WeightedEdge(6, 4, 0.93));
        return graph;
    }

    public static DirectedEdgeWeightedGraph smallAcyclicDirectedEdgeWeightedGraph() {
        DirectedEdgeWeightedGraph graph = new DirectedEdgeWeightedGraph(8);
        graph.add(new WeightedEdge(5, 4, 0.35));
        graph.add(new WeightedEdge(4, 7, 0.37));
        graph.add(new WeightedEdge(5, 7, 0.28));
        graph.add(new WeightedEdge(5, 1, 0.32));
        graph.add(new WeightedEdge(4, 0, 0.38));
        graph.add(new WeightedEdge(0, 2, 0.26));
        graph.add(new WeightedEdge(3, 7, 0.39));
        graph.add(new WeightedEdge(1, 3, 0.29));
        graph.add(new WeightedEdge(7, 2, 0.34));
        graph.add(new WeightedEdge(6, 2, 0.40));
        graph.add(new WeightedEdge(3, 6, 0.52));
        graph.add(new WeightedEdge(6, 0, 0.58));
        graph.add(new WeightedEdge(6, 4, 0.93));
        return graph;
    }
}
