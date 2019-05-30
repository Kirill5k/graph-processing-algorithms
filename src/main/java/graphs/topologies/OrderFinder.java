package graphs.topologies;

import graphs.datatypes.Graph;

import java.util.Collection;

public abstract class OrderFinder {
    protected final Graph graph;

    protected OrderFinder(Graph graph) {
        this.graph = graph;
    }

    public abstract Collection<Integer> order();
}
