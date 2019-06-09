package graphs.trees;


import graphs.datatypes.graphs.weight.EdgeWeightedGraph;
import graphs.datatypes.graphs.weight.WeightedEdge;

import java.util.Collection;

public abstract class MinimumSpanningTreeFinder {
    protected final EdgeWeightedGraph graph;

    protected MinimumSpanningTreeFinder(EdgeWeightedGraph graph) {
        this.graph = graph;
    }

    public abstract Collection<WeightedEdge> edges();

    public abstract double weight();
}
