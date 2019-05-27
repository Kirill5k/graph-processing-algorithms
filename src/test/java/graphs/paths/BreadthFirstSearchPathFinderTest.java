package graphs.paths;

import graphs.datatypes.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static graphs.datatypes.UndirectedGraphBuilder.smallUndirectedGraph;
import static org.assertj.core.api.Assertions.assertThat;

class BreadthFirstSearchPathFinderTest {

    private Graph graph;
    private PathFinder pathFinder;

    @BeforeEach
    void setUp() {
        graph = smallUndirectedGraph();
        pathFinder = new BreadthFirstSearchPathFinder(graph, 0);
    }

    @Test
    public void hasPathTo() {
        assertThat(pathFinder.hasPathTo(5)).isTrue();
    }

    @Test
    public void pathTo() {
        assertThat(pathFinder.pathTo(5)).containsExactly(0, 5);
    }

    @Test
    public void distanceTo() {
        assertThat(pathFinder.distanceTo(5)).isEqualTo(1);
    }
}