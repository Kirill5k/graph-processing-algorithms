package graphs.paths;

import graphs.datatypes.DirectedEdgeWeightedGraphBuilder;
import graphs.datatypes.graphs.weight.DirectedEdgeWeightedGraph;
import graphs.datatypes.graphs.weight.WeightedEdge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DijkstraShortestPathFinderTest {
    private DirectedEdgeWeightedGraph graph;
    private ShortestPathFinder shortestPathFinder;

    @BeforeEach
    void setUp() {
        graph = DirectedEdgeWeightedGraphBuilder.smallDirectedEdgeWeightedGraph();
        shortestPathFinder = new DijkstraShortestPathFinder(graph, 0);
    }

    @Test
    void hasPathTo() {
        assertThat(shortestPathFinder.hasPathTo(1)).isTrue();
        assertThat(shortestPathFinder.hasPathTo(2)).isTrue();
        assertThat(shortestPathFinder.hasPathTo(3)).isTrue();
        assertThat(shortestPathFinder.hasPathTo(4)).isTrue();
        assertThat(shortestPathFinder.hasPathTo(5)).isTrue();
        assertThat(shortestPathFinder.hasPathTo(6)).isTrue();
        assertThat(shortestPathFinder.hasPathTo(7)).isTrue();
    }

    @Test
    void pathTo() {
        assertThat(shortestPathFinder.pathTo(7)).containsExactly(new WeightedEdge(2, 7, 0.34), new WeightedEdge(0, 2, 0.26));
    }

    @Test
    void distanceTo() {
        assertThat(shortestPathFinder.distanceTo(4)).isEqualTo(0.38);
        assertThat(shortestPathFinder.distanceTo(5)).isEqualTo(0.73);
        assertThat(shortestPathFinder.distanceTo(6)).isEqualTo(1.51);
        assertThat(shortestPathFinder.distanceTo(7)).isEqualTo(0.6);
    }
}