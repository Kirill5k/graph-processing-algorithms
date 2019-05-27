package graphs.datatypes;

public class UndirectedGraphBuilder {
    private UndirectedGraphBuilder() {}

    public static Graph smallUndirectedGraph() {
        Graph graph = new UndirectedGraph(6);
        graph.addEdge(0, 5);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 2);
        graph.addEdge(0, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(0, 2);
        return graph;
    }

    public static Graph mediumUndirectedGraph() {
        Graph graph = new UndirectedGraph(13);
        graph.addEdge(0, 6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 11);
        graph.addEdge(9, 10);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);
        return graph;
    }
}
