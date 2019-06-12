package graphs.topologies;

import graphs.datatypes.DirectedGraphBuilder;
import graphs.datatypes.graphs.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class DepthFirstOrderFinderTest {

    private Graph graph;
    private OrderFinder orderFinder;

    @BeforeEach
    void setUp() {
        graph = DirectedGraphBuilder.smallDirectedGraph();
        orderFinder = new DepthFirstOrderFinder(graph);
    }

    @Test
    void order() {
        assertThat(orderFinder.order()).containsExactly(7, 8, 6, 9, 11, 10, 12, 0, 5, 4, 2, 3, 1);
    }
}