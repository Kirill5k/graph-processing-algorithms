package graphs.cycles;

import graphs.datatypes.Graph;

import java.util.Collection;
import java.util.Stack;

public class DepthFirstSearchCycleFinder extends CycleFinder {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    protected DepthFirstSearchCycleFinder(Graph graph) {
        super(graph);
        onStack = new boolean[graph.vertices()];
        edgeTo = new int[graph.vertices()];
        marked = new boolean[graph.vertices()];
        for (int vertex = 0; vertex < graph.vertices(); vertex++) {
            if (!marked[vertex]) {
                depthFirstSearch(vertex);
            }
        }
    }

    private void depthFirstSearch(int vertex) {
        marked[vertex] = true;
        onStack[vertex] = true;
        for (int adjacentVertex : graph.adjacentTo(vertex)) {
            if (hasCycle()) {
                return;
            } else if (!marked[adjacentVertex]) {
                edgeTo[adjacentVertex] = vertex;
                depthFirstSearch(adjacentVertex);
            } else if (onStack[adjacentVertex]) {
                createCycle(vertex, adjacentVertex);
            }
        }
        onStack[vertex] = false;
    }

    private void createCycle(int vertex, int adjacentVertex) {
        cycle = new Stack<>();
        for (int currentVertex = vertex; currentVertex != adjacentVertex; currentVertex = edgeTo[currentVertex]) {
            cycle.push(currentVertex);
        }
        cycle.push(adjacentVertex);
        cycle.push(vertex);
    }

    @Override
    public boolean hasCycle() {
        return cycle != null;
    }

    @Override
    public Collection<Integer> cycle() {
        return cycle;
    }
}
