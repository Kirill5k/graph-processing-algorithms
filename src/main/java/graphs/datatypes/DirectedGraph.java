package graphs.datatypes;

import java.util.*;

public class DirectedGraph implements Graph {
    private final int vertices;
    private int edges;
    private final List<Integer>[] adjacencyLists;

    public DirectedGraph(int vertices) {
        this.vertices = vertices;
        this.edges = 0;
        this.adjacencyLists = (List<Integer>[]) new List[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyLists[i] = new ArrayList<>();
        }
    }

    @Override
    public int vertices() {
        return vertices;
    }

    @Override
    public int edges() {
        return edges;
    }

    @Override
    public void addEdge(int vertexFrom, int vertexTo) {
        if (vertexFrom == vertexTo || hasEdge(vertexFrom, vertexTo)) {
            throw new IllegalArgumentException("parallel edges and self-loops are not allowed");
        }

        adjacencyLists[vertexFrom].add(vertexTo);
        edges++;
    }

    @Override
    public boolean hasEdge(int vertexFrom, int vertexTo) {
        return adjacencyLists[vertexFrom].contains(vertexTo);
    }

    /**
     * get vertices connected to vertex by edges pointing from vertex
     * @param vertex
     * @return list of vertices
     */
    @Override
    public Collection<Integer> adjacentTo(int vertex) {
        return adjacencyLists[vertex];
    }

    public DirectedGraph reverse() {
        DirectedGraph reversedGraph = new DirectedGraph(vertices);
        for (int vertex = 0; vertex < vertices; vertex++) {
            for (int adjacentVertex : adjacentTo(vertex)) {
                reversedGraph.addEdge(adjacentVertex, vertex);
            }
        }
        return reversedGraph;
    }
}
