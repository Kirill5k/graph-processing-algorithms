package graphs.trees;

import graphs.datatypes.weighted.EdgeWeightedGraph;
import graphs.datatypes.weighted.WeightedEdge;

import java.util.Collection;

public abstract class MinimumSpanningTreeFinder {
    protected final EdgeWeightedGraph graph;

    protected MinimumSpanningTreeFinder(EdgeWeightedGraph graph) {
        this.graph = graph;
    }

    public abstract Collection<WeightedEdge> edges();

    public abstract double weight();
}
