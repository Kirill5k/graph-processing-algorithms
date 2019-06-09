package graphs.datatypes;

import graphs.datatypes.graphs.Graph;
import graphs.datatypes.graphs.simple.SimpleEdge;
import graphs.datatypes.graphs.simple.UndirectedGraph;

public class UndirectedGraphBuilder {
    private UndirectedGraphBuilder() {}

    public static Graph smallUndirectedGraph() {
        Graph graph = new UndirectedGraph(6);
        graph.add(new SimpleEdge(5, 0));
        graph.add(new SimpleEdge(4, 2));
        graph.add(new SimpleEdge(3, 2));
        graph.add(new SimpleEdge(2, 1));
        graph.add(new SimpleEdge(1, 0));
        graph.add(new SimpleEdge(4, 3));
        graph.add(new SimpleEdge(5, 3));
        graph.add(new SimpleEdge(2, 0));
        return graph;
    }

    public static Graph mediumUndirectedGraph() {
        Graph graph = new UndirectedGraph(13);
        graph.add(new SimpleEdge(6, 0));
        graph.add(new SimpleEdge(1, 0));
        graph.add(new SimpleEdge(2, 0));
        graph.add(new SimpleEdge(5, 0));
        graph.add(new SimpleEdge(5, 3));
        graph.add(new SimpleEdge(4, 3));
        graph.add(new SimpleEdge(5, 4));
        graph.add(new SimpleEdge(6, 4));
        graph.add(new SimpleEdge(8, 7));
        graph.add(new SimpleEdge(11, 9));
        graph.add(new SimpleEdge(10, 9));
        graph.add(new SimpleEdge(12, 9));
        graph.add(new SimpleEdge(12, 11));
        return graph;
    }
}
