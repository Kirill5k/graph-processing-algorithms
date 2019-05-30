package graphs.connectors;

import graphs.datatypes.DirectedGraph;
import graphs.topologies.DepthFirstOrderFinder;

public class KosarajuConnectedComponentsIdentifier extends ConnectedComponentsIdentifier {
    private final boolean[] marked;
    private final int[] id;
    private int count;

    public KosarajuConnectedComponentsIdentifier(DirectedGraph graph) {
        super(graph);
        marked = new boolean[graph.vertices()];
        id = new int[graph.vertices()];
        DepthFirstOrderFinder orderFinder = new DepthFirstOrderFinder(graph);
        for (int vertex : orderFinder.order()) {
            if (!marked[vertex]) {
                depthFirstSearch(vertex);
                count++;
            }
        }
    }

    private void depthFirstSearch(int vertex) {
        marked[vertex] = true;
        id[vertex] = count;
        for (int adjacentVertex : graph.adjacentTo(vertex)) {
            if (!marked[adjacentVertex]) {
                depthFirstSearch(adjacentVertex);
            }
        }
    }

    @Override
    public boolean stronglyConnected(int vertex1, int vertex2) {
        return id[vertex1] == id[vertex2];
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public int id(int vertex) {
        return id[vertex];
    }
}
