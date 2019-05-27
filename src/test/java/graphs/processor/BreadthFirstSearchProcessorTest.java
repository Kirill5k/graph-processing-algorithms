package graphs.processor;

import graphs.datatypes.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static graphs.datatypes.UndirectedGraphBuilder.smallUndirectedGraph;
import static org.assertj.core.api.Assertions.assertThat;


class BreadthFirstSearchProcessorTest {

    private Graph graph;
    private GraphProcessor graphProcessor;

    @BeforeEach
    void setUp() {
        graph = smallUndirectedGraph();
        graphProcessor = new BreadthFirstSearchProcessor(graph, 0);
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