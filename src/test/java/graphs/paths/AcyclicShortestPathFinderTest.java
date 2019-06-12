package graphs.paths;

import graphs.datatypes.DirectedEdgeWeightedGraphBuilder;
import graphs.datatypes.graphs.weight.DirectedEdgeWeightedGraph;
import graphs.datatypes.graphs.weight.WeightedEdge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AcyclicShortestPathFinderTest {
    private DirectedEdgeWeightedGraph graph;
    private ShortestPathFinder shortestPathFinder;

    @BeforeEach
    void setUp() {
        graph = DirectedEdgeWeightedGraphBuilder.smallAcyclicDirectedEdgeWeightedGraph();
        shortestPathFinder = new AcyclicShortestPathFinder(graph, 5);
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
        assertThat(shortestPathFinder.pathTo(7)).containsExactly(new WeightedEdge(5, 7, 28));
    }

    @Test
    void distanceTo() {
        assertThat(shortestPathFinder.distanceTo(4)).isEqualTo(0.35);
        assertThat(shortestPathFinder.distanceTo(6)).isEqualTo(1.13);
        assertThat(shortestPathFinder.distanceTo(7)).isEqualTo(0.28);
    }
}