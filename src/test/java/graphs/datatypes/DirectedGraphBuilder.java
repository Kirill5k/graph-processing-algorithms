package graphs.datatypes;

import graphs.datatypes.simple.DirectedGraph;
import graphs.datatypes.simple.SimpleEdge;

public class DirectedGraphBuilder {
    private DirectedGraphBuilder() {}

    public static DirectedGraph stronglyConnectedGraph() {
        DirectedGraph graph = new DirectedGraph(13);
        graph.add(new SimpleEdge(0, 1));
        graph.add(new SimpleEdge(0, 2));
        graph.add(new SimpleEdge(2, 0));
        graph.add(new SimpleEdge(2, 3));
        graph.add(new SimpleEdge(3, 2));
        graph.add(new SimpleEdge(3, 5));
        graph.add(new SimpleEdge(4, 2));
        graph.add(new SimpleEdge(4, 3));
        graph.add(new SimpleEdge(5, 4));
        graph.add(new SimpleEdge(6, 0));
        graph.add(new SimpleEdge(6, 4));
        graph.add(new SimpleEdge(6, 9));
        graph.add(new SimpleEdge(7, 6));
        graph.add(new SimpleEdge(7, 8));
        graph.add(new SimpleEdge(8, 7));
        graph.add(new SimpleEdge(8, 9));
        graph.add(new SimpleEdge(9, 10));
        graph.add(new SimpleEdge(9, 11));
        graph.add(new SimpleEdge(10, 12));
        graph.add(new SimpleEdge(11, 4));
        graph.add(new SimpleEdge(11, 12));
        graph.add(new SimpleEdge(12, 9));
        return graph;
    }

    public static Graph smallDirectedGraph() {
        Graph graph = new DirectedGraph(13);
        graph.add(new SimpleEdge(4, 2));
        graph.add(new SimpleEdge(2, 3));
        graph.add(new SimpleEdge(3, 2));
        graph.add(new SimpleEdge(6, 0));
        graph.add(new SimpleEdge(0, 1));
        graph.add(new SimpleEdge(2, 0));
        graph.add(new SimpleEdge(11, 12));
        graph.add(new SimpleEdge(12, 9));
        graph.add(new SimpleEdge(9, 10));
        graph.add(new SimpleEdge(9, 11));
        graph.add(new SimpleEdge(8, 9));
        graph.add(new SimpleEdge(10, 12));
        graph.add(new SimpleEdge(11, 4));
        graph.add(new SimpleEdge(4, 3));
        graph.add(new SimpleEdge(3, 5));
        graph.add(new SimpleEdge(7, 8));
        graph.add(new SimpleEdge(8, 7));
        graph.add(new SimpleEdge(5, 4));
        graph.add(new SimpleEdge(0, 5));
        graph.add(new SimpleEdge(6, 4));
        graph.add(new SimpleEdge(6, 9));
        graph.add(new SimpleEdge(7, 6));
        return graph;
    }
}
