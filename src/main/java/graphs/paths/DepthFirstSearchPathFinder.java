package graphs.paths;

import graphs.datatypes.graphs.Edge;
import graphs.datatypes.graphs.Graph;

import java.util.Collection;
import java.util.LinkedList;

import static java.util.Collections.emptyList;

public class DepthFirstSearchPathFinder extends PathFinder {
    private boolean[] marked;
    private int[] edgeTo;

    public DepthFirstSearchPathFinder(Graph<Edge> graph, int source) {
        super(graph, source);
        marked = new boolean[graph.vertices()];
        edgeTo = new int[graph.vertices()];
        depthFirstSearch(source);
    }

    public void depthFirstSearch(int vertex) {
        marked[vertex] = true;
        for (int adjacentVertex : graph.adjacentTo(vertex)) {
            if (!marked[adjacentVertex]) {
                edgeTo[adjacentVertex] = vertex;
                depthFirstSearch(adjacentVertex);
            }
        }
    }

    @Override
    public boolean hasPathTo(int vertex) {
        return marked[vertex];
    }

    @Override
    public Collection<Integer> pathTo(int vertex) {
        if (!hasPathTo(vertex)) {
            return emptyList();
        }

        LinkedList<Integer> path = new LinkedList<>();
        for (int currentVertex = vertex; currentVertex != source; currentVertex = edgeTo[currentVertex]) {
            path.push(currentVertex);
        }
        path.push(source);
        return path;
    }

    @Override
    public int distanceTo(int vertex) {
        int distance = 0;
        for (int currentVertex = vertex; currentVertex != source; currentVertex = edgeTo[currentVertex]) {
            distance++;
        }
        return distance;
    }
}
