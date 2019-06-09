package graphs.connectors;

import graphs.datatypes.graphs.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static graphs.datatypes.UndirectedGraphBuilder.mediumUndirectedGraph;
import static org.assertj.core.api.Assertions.assertThat;

class UnionFindConnectorTest {

    private Graph graph;
    private Connector connector;

    @BeforeEach
    void setup() {
        graph = mediumUndirectedGraph();
        connector = new UnionFindConnector(graph);
    }

    @Test
    void areConnected() {
        assertThat(connector.areConnected(0, 6)).isTrue();
        assertThat(connector.areConnected(0, 4)).isTrue();
        assertThat(connector.areConnected(0, 11)).isFalse();
    }

    @Test
    void id() {
        assertThat(connector.id(0)).isEqualTo(1);
        assertThat(connector.id(2)).isEqualTo(1);
        assertThat(connector.id(1)).isEqualTo(1);
        assertThat(connector.id(5)).isEqualTo(1);

        assertThat(connector.id(8)).isEqualTo(8);
    }

    @Test
    void count() {
        assertThat(connector.count()).isEqualTo(3);
    }
}