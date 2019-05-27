package graphs.datatypes;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UndirectedGraph implements Graph {

    private final Set<Integer>[] adjacencyList;
    private final int vertices;
    private int edges = 0;

    public UndirectedGraph(int vertices) {
        this.vertices = vertices;
        adjacencyList = (Set<Integer>[]) new Set[vertices];
        for (int vertex = 0; vertex < vertices; vertex++) {
            adjacencyList[vertex] = new HashSet<>();
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

        adjacencyList[vertexFrom].add(vertexTo);
        adjacencyList[vertexTo].add(vertexFrom);
        edges++;
    }

    @Override
    public boolean hasEdge(int vertexFrom, int vertexTo) {
        return adjacencyList[vertexFrom].contains(vertexTo) || adjacencyList[vertexTo].contains(vertexFrom);
    }

    @Override
    public Collection<Integer> adjacentTo(int vertex) {
        return adjacencyList[vertex];
    }
}
