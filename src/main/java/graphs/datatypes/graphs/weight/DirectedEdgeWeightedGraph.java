package graphs.datatypes.graphs.weight;

import graphs.datatypes.graphs.Graph;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class DirectedEdgeWeightedGraph implements Graph<WeightedEdge> {
    private final int vertices;
    private final List<WeightedEdge> edges;
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
    public void add(WeightedEdge edge) {
        if (edge.isSelfloop() || has(edge)) {
            throw new IllegalArgumentException("parallel edges and self-loops are not allowed");
        }

        adjacencySets[edge.from()].add(edge.to());
        edges.add(edge);
    }

    @Override
    public boolean has(WeightedEdge edge) {
        return adjacencySets[edge.from()].contains(edge.to());
    }

    @Override
    public Collection<Integer> adjacentTo(int vertex) {
        return adjacencySets[vertex];
    }

    @Override
    public Collection<WeightedEdge> adjacentEdges(int vertex) {
        return edges.stream()
                .filter(edge -> edge.from() == vertex)
                .collect(toList());
    }

    @Override
    public Collection<WeightedEdge> allEdges() {
        return edges;
    }
}
