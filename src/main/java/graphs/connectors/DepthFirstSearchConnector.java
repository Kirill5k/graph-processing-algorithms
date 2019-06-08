package graphs.connectors;

import graphs.datatypes.Edge;
import graphs.datatypes.Graph;

public class DepthFirstSearchConnector extends Connector {
    private final boolean[] marked;
    private final int[] ids;

    public DepthFirstSearchConnector(Graph<Edge> graph) {
        super(graph);
        marked = new boolean[graph.vertices()];
        ids = new int[graph.vertices()];
        for (int vertex = 0; vertex < graph.vertices(); vertex++) {
            if (!marked[vertex]) {
                depthFirstSearch(vertex);
                count++;
            }
        }
    }

    private void depthFirstSearch(int vertex) {
        marked[vertex] = true;
        ids[vertex] = count;
        for (int adjacentVertex : graph.adjacentTo(vertex)) {
            if (!marked[adjacentVertex]) {
                depthFirstSearch(adjacentVertex);
            }
        }
    }

    @Override
    public boolean areConnected(int vertex1, int vertex2) {
        return ids[vertex1] == ids[vertex2];
    }

    @Override
    public int id(int vertex) {
        return ids[vertex];
    }
}
