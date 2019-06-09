package graphs.trees;

import graphs.datatypes.graphs.Edge;
import graphs.datatypes.graphs.weight.EdgeWeightedGraph;
import graphs.datatypes.graphs.weight.WeightedEdge;

import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LazyPrimMinimumSpanningTreeFinder extends MinimumSpanningTreeFinder {
    private static final int STARTING_VERTEX = 0;

    private final boolean[] marked;
    private final LinkedList<WeightedEdge> minimumSpanningTree = new LinkedList<>();
    private final PriorityQueue<WeightedEdge> crossingEdges = new PriorityQueue<>();

    protected LazyPrimMinimumSpanningTreeFinder(EdgeWeightedGraph graph) {
        super(graph);
        marked = new boolean[graph.vertices()];
        visit(STARTING_VERTEX);
        while (!crossingEdges.isEmpty()) {
            WeightedEdge edge = crossingEdges.poll();
            if (isNotVisited(edge)) {
                minimumSpanningTree.add(edge);
                visitIfNotMarked(edge.from());
                visitIfNotMarked(edge.to());
            }
        }
    }

    private boolean isNotVisited(Edge edge) {
        return !marked[edge.from()] || !marked[edge.to()];
    }

    private void visitIfNotMarked(int vertex) {
        if (!marked[vertex]) {
            visit(vertex);
        }
    }

    private void visit(int vertex) {
        marked[vertex] = true;
        for (WeightedEdge edge: graph.adjacentEdges(vertex)) {
            if (!marked[edge.other(vertex)]) {
                crossingEdges.add(edge);
            }
        }
    }

    @Override
    public Collection<WeightedEdge> edges() {
        return minimumSpanningTree;
    }

    @Override
    public double weight() {
        return minimumSpanningTree.stream()
                .mapToDouble(WeightedEdge::weight)
                .sum();
    }
}
