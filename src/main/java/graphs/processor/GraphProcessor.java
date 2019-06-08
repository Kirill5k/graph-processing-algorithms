package graphs.processor;

import graphs.datatypes.Edge;
import graphs.datatypes.Graph;

public abstract class GraphProcessor {
    protected Graph<Edge> graph;
    protected int source;

    public GraphProcessor(Graph<Edge> graph, int source) {
        this.graph = graph;
        this.source = source;
    }

    public abstract boolean isMarked(int vertex);

    public abstract int count();
}
