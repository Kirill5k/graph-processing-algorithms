package graphs.cycles;

import graphs.datatypes.Graph;

import java.util.Collection;

public abstract class CycleFinder {
    protected final Graph graph;

    protected CycleFinder(Graph graph) {
        this.graph = graph;
    }

    public abstract boolean hasCycle();

    public abstract Collection<Integer> cycle();
}
