package graphs.processor;

import graphs.datatypes.graphs.Graph;

import java.util.LinkedList;

public class BreadthFirstSearchProcessor extends GraphProcessor {
    private boolean[] marked;
    private int count;

    public BreadthFirstSearchProcessor(Graph graph, int source) {
        super(graph, source);
        marked = new boolean[graph.vertices()];
        breadthFirstSearch();
    }

    private void breadthFirstSearch() {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        marked[source] = true;
        count++;
        while (!queue.isEmpty()) {
            int vertex = queue.pollFirst();
            for (int adjacentVertex : graph.adjacentTo(vertex)) {
                if (!marked[adjacentVertex]) {
                    queue.add(adjacentVertex);
                    marked[adjacentVertex] = true;
                    count++;
                }
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
