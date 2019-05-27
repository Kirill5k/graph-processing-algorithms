package graphs.processor;

import graphs.datatypes.Graph;

public abstract class GraphProcessor {
    protected Graph graph;
    protected int source;

    public GraphProcessor(Graph graph, int source) {
        this.graph = graph;
        this.source = source;
    }

    public abstract boolean isMarked(int vertex);

    public abstract int count();
}
