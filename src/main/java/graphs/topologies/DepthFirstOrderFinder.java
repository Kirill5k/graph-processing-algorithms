package graphs.topologies;

import graphs.datatypes.graphs.Edge;
import graphs.datatypes.graphs.Graph;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstOrderFinder extends OrderFinder {
    private boolean[] marked;
    private Queue<Integer> preOrder;
    private Queue<Integer> postOrder;
    private Stack<Integer> reversePostOrder;

    public DepthFirstOrderFinder(Graph<Edge> graph) {
        super(graph);
        marked = new boolean[graph.vertices()];
        preOrder = new LinkedList<>();
        postOrder = new LinkedList<>();
        reversePostOrder = new Stack<>();
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
        reversePostOrder.push(vertex);
    }

    @Override
    public Collection<Integer> order() {
        return reversePostOrder;
    }
}
