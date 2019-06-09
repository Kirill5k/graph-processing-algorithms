package graphs.connectors;

import graphs.datatypes.graphs.Graph;

public class UnionFindConnector extends Connector {
    private int[] ids;
    private int[] sizes;

    public UnionFindConnector(Graph graph) {
        super(graph);
        ids = new int[graph.vertices()];
        sizes = new int[graph.vertices()];
        count = graph.vertices();
        for (int i = 0; i < graph.vertices(); i++) {
            ids[i] = i;
            sizes[i] = 1;
        }
        for (int vertex = 0; vertex < graph.vertices(); vertex++) {
            unionFind(vertex);
        }
    }

    private void unionFind(int vertex) {
        for (int adjacentVertex : graph.adjacentTo(vertex)) {
            if (!areConnected(vertex, adjacentVertex)) {
                count--;
                connect(vertex, adjacentVertex);
                unionFind(adjacentVertex);
            }
        }
    }

    private void connect(int vertex1, int vertex2) {
        int v1id = id(vertex1);
        int v2id = id(vertex2);

        if (sizes[v1id] > sizes[v2id]) {
            sizes[v1id] += sizes[v2id];
            ids[v2id] = ids[v1id];
        } else {
            sizes[v2id] += sizes[v1id];
            ids[v1id] = ids[v2id];
        }
    }

    @Override
    public boolean areConnected(int vertex1, int vertex2) {
        return id(vertex1) == id(vertex2);
    }

    @Override
    public int id(int vertex) {
        int root = ids[vertex];
        while (root != ids[root]) {
            root = ids[root];
        }

        return root;
    }
}
