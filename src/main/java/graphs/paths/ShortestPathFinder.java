package graphs.paths;

import graphs.datatypes.graphs.weight.DirectedEdgeWeightedGraph;
import graphs.datatypes.graphs.weight.WeightedEdge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public abstract class ShortestPathFinder {
    protected static final double INITIAL_DISTANCE = 0;

    protected final DirectedEdgeWeightedGraph graph;
    protected final int source;
    protected final WeightedEdge[] edgeTo;
    protected final double[] distanceTo;

    protected ShortestPathFinder(DirectedEdgeWeightedGraph graph, int source) {
        this.graph = graph;
        this.source = source;
        edgeTo = new WeightedEdge[graph.vertices()];
        distanceTo = new double[graph.vertices()];
        Arrays.fill(distanceTo, Double.POSITIVE_INFINITY);
    }

    protected void relaxEdge(WeightedEdge edge) {
        double alternativeDistance = distanceTo[edge.from()] + edge.weight();
        if (distanceTo[edge.to()] > alternativeDistance) {
            edgeTo[edge.to()] = edge;
            distanceTo[edge.to()] = alternativeDistance;
        }
    }

    public boolean hasPathTo(int vertex) {
        if (vertex >= graph.vertices() || vertex < 0) {
            throw new IllegalArgumentException("vertex is not in the graph");
        }
        return distanceTo[vertex] < Double.POSITIVE_INFINITY;
    }

    public Collection<WeightedEdge> pathTo(int vertex) {
        if (!hasPathTo(vertex)) {
            throw new IllegalArgumentException("vertex is not on the path");
        }

        List<WeightedEdge> path = new ArrayList<>();
        for (WeightedEdge edge = edgeTo[vertex]; edge != null; edge = edgeTo[edge.from()]) {
            path.add(edge);
        }

        return path;
    }

    public double distanceTo(int vertex) {
        return distanceTo[vertex];
    }
}
