package graphs.degrees;

import graphs.datatypes.graphs.simple.DirectedGraph;
import graphs.datatypes.DirectedGraphBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DigraphDegreeMeasureTest {
    private DegreeMeasure degreeMeasure;
    private DirectedGraph graph;

    @BeforeEach
    void setUp() {
        graph = DirectedGraphBuilder.stronglyConnectedGraph();
        degreeMeasure = new DigraphDegreeMeasure(graph);
    }

    @Test
    void indegree() {
        assertThat(degreeMeasure.indegree(0)).isEqualTo(2);
        assertThat(degreeMeasure.indegree(12)).isEqualTo(2);
        assertThat(degreeMeasure.indegree(4)).isEqualTo(3);
    }

    @Test
    void outdegree() {
        assertThat(degreeMeasure.outdegree(0)).isEqualTo(2);
        assertThat(degreeMeasure.outdegree(6)).isEqualTo(3);

    }

    @Test
    void sources() {
        assertThat(degreeMeasure.sources()).isEmpty();
    }

    @Test
    void sinks() {
        assertThat(degreeMeasure.sinks()).containsExactly(1);
    }

    @Test
    void isMap() {
        assertThat(degreeMeasure.isMap()).isFalse();
    }
}