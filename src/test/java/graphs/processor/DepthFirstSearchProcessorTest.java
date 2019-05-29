package graphs.processor;

import graphs.datatypes.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static graphs.datatypes.DirectedGraphBuilder.smallDirectedGraph;
import static org.assertj.core.api.Assertions.assertThat;


class DepthFirstSearchProcessorTest {

    private Graph directedGraph;
    private GraphProcessor graphProcessor;

    @BeforeEach
    void setUp() {
        directedGraph = smallDirectedGraph();
        graphProcessor = new DepthFirstSearchProcessor(directedGraph, 0);
    }

    @Test
    public void isMarked() {
        assertThat(graphProcessor.isMarked(4)).isTrue();
    }

    @Test
    public void count() {
        assertThat(graphProcessor.count()).isEqualTo(6);
    }
}