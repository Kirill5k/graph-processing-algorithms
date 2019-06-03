package graphs.datatypes.simple;

import graphs.datatypes.Edge;
import graphs.datatypes.Graph;

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
    public void add(Edge edge) {
        if (edge.isSelfloop() || has(edge)) {
            throw new IllegalArgumentException("parallel edges and self-loops are not allowed");
        }

        adjacencyList[edge.from()].add(edge.to());
        adjacencyList[edge.to()].add(edge.from());
        edges++;
    }

    @Override
    public boolean has(Edge edge) {
        return adjacencyList[edge.from()].contains(edge.to()) || adjacencyList[edge.to()].contains(edge.from());
    }

    @Override
    public Collection<Integer> adjacentTo(int vertex) {
        return adjacencyList[vertex];
    }
}
