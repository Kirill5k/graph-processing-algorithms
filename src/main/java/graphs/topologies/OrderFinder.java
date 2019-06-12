package graphs.topologies;

import graphs.datatypes.graphs.Edge;
import graphs.datatypes.graphs.Graph;

import java.util.Collection;

public abstract class OrderFinder<T extends Edge> {
    protected final Graph<T> graph;

    protected OrderFinder(Graph<T> graph) {
        this.graph = graph;
    }

    public abstract Collection<Integer> order();
}
