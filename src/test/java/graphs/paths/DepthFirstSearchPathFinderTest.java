package graphs.paths;

import graphs.datatypes.graphs.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static graphs.datatypes.UndirectedGraphBuilder.smallUndirectedGraph;
import static org.assertj.core.api.Assertions.assertThat;

class DepthFirstSearchPathFinderTest {

    private Graph graph;
    private PathFinder pathFinder;

    @BeforeEach
    void setUp() {
        graph = smallUndirectedGraph();
        pathFinder = new DepthFirstSearchPathFinder(graph, 0);
    }

    @Test
    public void hasPathTo() {
        assertThat(pathFinder.hasPathTo(5)).isTrue();
    }

    @Test
    public void pathTo() {
        assertThat(pathFinder.pathTo(5)).containsExactly(0, 1, 2, 3, 5);
    }

    @Test
    public void distanceTo() {
        assertThat(pathFinder.distanceTo(5)).isEqualTo(4);
    }
}