package graphs.trees;

import graphs.datatypes.EdgeWeightedGraphBuilder;
import graphs.datatypes.weighted.EdgeWeightedGraph;
import graphs.datatypes.weighted.WeightedEdge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EagerPrimMinimumSpanningTreeFinderTest {

    private EdgeWeightedGraph graph;
    private MinimumSpanningTreeFinder mstFinder;

    @BeforeEach
    void setUp() {
        graph = EdgeWeightedGraphBuilder.smallEdgeWeightedGraph();
        mstFinder = new EagerPrimMinimumSpanningTreeFinder(graph);
    }

    @Test
    void edges() {
        assertThat(mstFinder.edges()).containsExactlyInAnyOrder(
                new WeightedEdge(0, 7, 0.16),
                new WeightedEdge(1, 7, 0.19),
                new WeightedEdge(0, 2, 0.26),
                new WeightedEdge(2, 3, 0.17),
                new WeightedEdge(5, 7, 0.28),
                new WeightedEdge(4, 5, 0.35),
                new WeightedEdge(6, 2, 0.40)
        );
    }

    @Test
    void weight() {
        assertThat(mstFinder.weight()).isEqualTo(1.81);
    }

}