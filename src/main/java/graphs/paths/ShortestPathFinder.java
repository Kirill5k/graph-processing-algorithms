package graphs.paths;

import graphs.datatypes.weighted.DirectedEdgeWeightedGraph;
import graphs.datatypes.weighted.WeightedEdge;

import java.util.Collection;

public abstract class ShortestPathFinder {
    protected final DirectedEdgeWeightedGraph graph;
    protected final int source;

    protected ShortestPathFinder(DirectedEdgeWeightedGraph graph, int source) {
        this.graph = graph;
        this.source = source;
    }

    public abstract double distTo(int vertex);

    public abstract boolean hasPathTo(int vertex);

    public abstract Collection<WeightedEdge> pathTo(int vertex);
}
