package graphs.topologies;

import graphs.datatypes.graphs.Edge;
import graphs.datatypes.graphs.Graph;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class DepthFirstOrderFinder<T extends Edge> extends OrderFinder<T> {
    private boolean[] marked;
    private Queue<Integer> preOrder;
    private Queue<Integer> postOrder;
    private LinkedList<Integer> reversePostOrder;

    public DepthFirstOrderFinder(Graph<T> graph) {
        super(graph);
        marked = new boolean[graph.vertices()];
        preOrder = new LinkedList<>();
        postOrder = new LinkedList<>();
        reversePostOrder = new LinkedList<>();
        for (int vertex = 0; vertex < graph.vertices(); vertex++) {
            if (!marked[vertex]) {
                depthFirstSearch(vertex);
            }
        }
    }

    private void depthFirstSearch(int vertex) {
        marked[vertex] = true;
        preOrder.add(vertex);
        for (int adjacentVertex : graph.adjacentTo(vertex)) {
            if (!marked[adjacentVertex]) {
                depthFirstSearch(adjacentVertex);
            }
        }
        postOrder.add(vertex);
        reversePostOrder.addFirst(vertex);
    }

    @Override
    public Collection<Integer> order() {
        return reversePostOrder;
    }
}
