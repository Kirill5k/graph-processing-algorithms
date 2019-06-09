package graphs.paths;

import graphs.datatypes.graphs.weight.DirectedEdgeWeightedGraph;

public class DijkstraShortestPathFinder extends ShortestPathFinder {
    public DijkstraShortestPathFinder(DirectedEdgeWeightedGraph graph, int source) {
        super(graph, source);
        distanceTo[source] = INITIAL_DISTANCE;
    }
}
