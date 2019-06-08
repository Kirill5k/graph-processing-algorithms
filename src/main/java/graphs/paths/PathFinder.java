package graphs.paths;

import graphs.datatypes.Edge;
import graphs.datatypes.Graph;

import java.util.Collection;

public abstract class PathFinder {
    protected Graph<Edge> graph;
    protected int source;

    public PathFinder(Graph<Edge> graph, int source) {
        this.graph = graph;
        this.source = source;
    }

    public abstract boolean hasPathTo(int vertex);

    public abstract Collection<Integer> pathTo(int vertex);

    public abstract int distanceTo(int vertex);
}
