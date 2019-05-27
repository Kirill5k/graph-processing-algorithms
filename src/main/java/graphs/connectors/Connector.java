package graphs.connectors;

import graphs.datatypes.Graph;

public abstract class Connector {
    protected final Graph graph;
    protected int count;

    public Connector(Graph graph) {
        this.graph = graph;
    }

    public abstract boolean areConnected(int vertex1, int vertex2);

    public abstract int id(int vertex);

    public int count() {
        return count;
    }
}
