package graphs.processor;

import graphs.datatypes.Graph;

public class DepthFirstSearchProcessor extends GraphProcessor {
    private boolean[] marked;
    private int count;

    public DepthFirstSearchProcessor(Graph graph, int source) {
        super(graph, source);
        marked = new boolean[graph.vertices()];
        depthFirstSearch(source);
    }

    private void depthFirstSearch(int vertex) {
        marked[vertex] = true;
        count++;
        for (int adjacentVertex : graph.adjacentTo(vertex)) {
            if (!marked[adjacentVertex]) {
                depthFirstSearch(adjacentVertex);
            }
        }
    }

    @Override
    public boolean isMarked(int vertex) {
        return marked[vertex];
    }

    @Override
    public int count() {
        return count;
    }
}
