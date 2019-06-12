package graphs.datatypes.graphs.weight;

import graphs.datatypes.graphs.Graph;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class EdgeWeightedGraph implements Graph<WeightedEdge> {
    protected final int vertices;
    protected final List<WeightedEdge> edges;
    protected final Set<Integer>[] adjacencySets;

    public EdgeWeightedGraph(int vertices) {
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
        adjacencySets[edge.to()].add(edge.from());
        edges.add(edge);
    }

    @Override
    public boolean has(WeightedEdge edge) {
        return adjacencySets[edge.from()].contains(edge.to()) || adjacencySets[edge.to()].contains(edge.from());
    }

    @Override
    public Collection<Integer> adjacentTo(int vertex) {
        return adjacencySets[vertex];
    }

    @Override
    public Collection<WeightedEdge> adjacentEdges(int vertex) {
        return edges.stream()
                .filter(edge -> edge.to() == vertex || edge.from() == vertex)
                .collect(toList());
    }

    @Override
    public Collection<WeightedEdge> allEdges() {
        return edges;
    }
}
