package graphs.topologies;

import graphs.datatypes.Edge;
import graphs.datatypes.Graph;

import java.util.Collection;

public abstract class OrderFinder {
    protected final Graph<Edge> graph;

    protected OrderFinder(Graph<Edge> graph) {
        this.graph = graph;
    }

    public abstract Collection<Integer> order();
}
