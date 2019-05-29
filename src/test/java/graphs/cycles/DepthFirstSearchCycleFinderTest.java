package graphs.cycles;

import graphs.datatypes.DirectedGraphBuilder;
import graphs.datatypes.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DepthFirstSearchCycleFinderTest {

    private Graph graph;
    private CycleFinder cycleFinder;

    @BeforeEach
    void setUp() {
        graph = DirectedGraphBuilder.smallDirectedGraph();
        cycleFinder = new DepthFirstSearchCycleFinder(graph);
    }

    @Test
    void hasCycle() {
        assertThat(cycleFinder.hasCycle()).isTrue();
    }

    @Test
    void cycle() {
        assertThat(cycleFinder.cycle()).containsExactly(3, 2, 3);
    }
}