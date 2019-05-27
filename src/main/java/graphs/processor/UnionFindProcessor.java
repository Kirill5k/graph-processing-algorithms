package graphs.processor;

import graphs.datatypes.Graph;

public class UnionFindProcessor extends GraphProcessor {
    private int[] ids;
    private int[] sizes;

    public UnionFindProcessor(Graph graph, int source) {
        super(graph, source);
        ids = new int[graph.vertices()];
        sizes = new int[graph.vertices()];
        for (int i = 0; i < graph.vertices(); i++) {
            ids[i] = i;
            sizes[i] = 1;
        }
        unionFind(source);
    }

    private void unionFind(int vertex) {
        for (int adjacentVertex : graph.adjacentTo(vertex)) {
            if (!areConnected(adjacentVertex, vertex)) {
                connect(vertex, adjacentVertex);
                unionFind(adjacentVertex);
            }
        }
    }

    private void connect(int vertex1, int vertex2) {
        int v1id = find(vertex1);
        int v2id = find(vertex2);

        if (sizes[v1id] > sizes[v2id]) {
            ids[v2id] = v1id;
            sizes[v1id] += sizes[v2id];
        } else {
            ids[v1id] = v2id;
            sizes[v2id] += sizes[v1id];
        }
    }

    private int find(int vertex) {
        int rootVertex = vertex;
        while (rootVertex != ids[rootVertex]) {
            rootVertex = ids[rootVertex];
        }

        return rootVertex;
    }

    private boolean areConnected(int vertex1, int vertex2) {
        return find(vertex1) == find(vertex2);
    }

    @Override
    public boolean isMarked(int vertex) {
        return areConnected(source, vertex);
    }

    @Override
    public int count() {
        return sizes[find(source)];
    }
}
