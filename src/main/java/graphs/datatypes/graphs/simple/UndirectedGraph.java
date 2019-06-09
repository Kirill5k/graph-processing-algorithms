package graphs.datatypes.graphs.simple;

import graphs.datatypes.graphs.Edge;
import graphs.datatypes.graphs.Graph;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class UndirectedGraph implements Graph<Edge> {

    private final Set<Integer>[] adjacencySets;
    private final List<Edge> edges;
    private final int vertices;
    public UndirectedGraph(int vertices) {
        this.edges = new ArrayList<>();
        this.vertices = vertices;
        adjacencySets = (Set<Integer>[]) new Set[vertices];
        for (int vertex = 0; vertex < vertices; vertex++) {
            adjacencySets[vertex] = new HashSet<>();
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

        adjacencySets[edge.from()].add(edge.to());
        adjacencySets[edge.to()].add(edge.from());
        edges.add(edge);
    }

    @Override
    public boolean has(Edge edge) {
        return adjacencySets[edge.from()].contains(edge.to()) || adjacencySets[edge.to()].contains(edge.from());
    }

    @Override
    public Collection<Integer> adjacentTo(int vertex) {
        return adjacencySets[vertex];
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
