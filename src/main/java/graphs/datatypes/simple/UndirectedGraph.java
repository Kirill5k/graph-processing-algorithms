package graphs.datatypes.simple;

import graphs.datatypes.Edge;
import graphs.datatypes.Graph;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class UndirectedGraph implements Graph {

    private final Set<Integer>[] adjacencyLists;
    private final List<Edge> edges;
    private final int vertices;
    public UndirectedGraph(int vertices) {
        this.edges = new ArrayList<>();
        this.vertices = vertices;
        adjacencyLists = (Set<Integer>[]) new Set[vertices];
        for (int vertex = 0; vertex < vertices; vertex++) {
            adjacencyLists[vertex] = new HashSet<>();
        }
    }

    @Override
    public int vertices() {
        return vertices;
    }

    @Override
    public int edges() {
        return edges.size();
    }

    @Override
    public void add(Edge edge) {
        if (edge.isSelfloop() || has(edge)) {
            throw new IllegalArgumentException("parallel edges and self-loops are not allowed");
        }

        adjacencyLists[edge.from()].add(edge.to());
        adjacencyLists[edge.to()].add(edge.from());
        edges.add(edge);
    }

    @Override
    public boolean has(Edge edge) {
        return adjacencyLists[edge.from()].contains(edge.to()) || adjacencyLists[edge.to()].contains(edge.from());
    }

    @Override
    public Collection<Integer> adjacentTo(int vertex) {
        return adjacencyLists[vertex];
    }

    @Override
    public Collection<Edge> adjacentEdges(int vertex) {
        return edges.stream()
                .filter(edge -> edge.from() == vertex || edge.to() == vertex)
                .collect(toList());
    }

    @Override
    public Collection<Edge> allEdges() {
        return edges;
    }
}
