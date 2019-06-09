package graphs.topologies;

import graphs.datatypes.graphs.Graph;

import java.util.Collection;

public abstract class TopologyFinder {
    protected final Graph graph;

    protected TopologyFinder(Graph graph) {
        this.graph = graph;
    }

    public abstract boolean isDirectedAcyclic();

    public abstract Collection<Integer> order();
}
