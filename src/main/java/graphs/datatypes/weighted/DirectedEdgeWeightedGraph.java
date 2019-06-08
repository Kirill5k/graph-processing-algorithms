package graphs.datatypes.weighted;

import graphs.datatypes.Edge;
import graphs.datatypes.Graph;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class DirectedEdgeWeightedGraph implements Graph {
    private final int vertices;
    private final List<Edge> edges;
    private final Set<Integer>[] adjacencySets;

    public DirectedEdgeWeightedGraph(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
        this.adjacencySets = (Set<Integer>[]) new Set[vertices];
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
        if (!(edge instanceof WeightedEdge)) {
            throw new IllegalArgumentException("must be weighted edge");
        }
        if (edge.isSelfloop() || has(edge)) {
            throw new IllegalArgumentException("parallel edges and self-loops are not allowed");
        }

        adjacencySets[edge.from()].add(edge.to());
        edges.add(edge);
    }

    @Override
    public boolean has(Edge edge) {
        return adjacencySets[edge.from()].contains(edge.to());
    }

    @Override
    public Collection<Integer> adjacentTo(int vertex) {
        return adjacencySets[vertex];
    }

    @Override
    public Collection<Edge> adjacentEdges(int vertex) {
        return edges.stream()
                .filter(edge -> edge.from() == vertex)
                .collect(toList());
    }

    @Override
    public Collection<Edge> allEdges() {
        return edges;
    }
}
