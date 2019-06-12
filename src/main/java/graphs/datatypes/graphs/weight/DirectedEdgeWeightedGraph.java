package graphs.datatypes.graphs.weight;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class DirectedEdgeWeightedGraph extends EdgeWeightedGraph {
    public DirectedEdgeWeightedGraph(int vertices) {
        super(vertices);
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
    public Collection<WeightedEdge> adjacentEdges(int vertex) {
        return edges.stream()
                .filter(edge -> edge.from() == vertex)
                .collect(toList());
    }
}
