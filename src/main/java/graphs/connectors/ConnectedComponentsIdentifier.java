package graphs.connectors;

import graphs.datatypes.graphs.simple.DirectedGraph;

public abstract class ConnectedComponentsIdentifier {
    protected final DirectedGraph graph;

    public ConnectedComponentsIdentifier(DirectedGraph graph) {
        this.graph = graph;
    }

    public abstract boolean stronglyConnected(int vertex1, int vertex2);

    public abstract int count();

    public abstract int id(int vertex);
}
