package graphs.cycles;

import graphs.datatypes.Edge;
import graphs.datatypes.Graph;

import java.util.Collection;

public abstract class CycleFinder {
    protected final Graph<Edge> graph;

    protected CycleFinder(Graph<Edge> graph) {
        this.graph = graph;
    }

    public abstract boolean hasCycle();

    public abstract Collection<Integer> cycle();
}
