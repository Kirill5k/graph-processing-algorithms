package graphs.connectors;

import graphs.datatypes.graphs.simple.DirectedGraph;
import graphs.datatypes.DirectedGraphBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KosarajuConnectedComponentsIdentifierTest {

    private DirectedGraph graph;
    private ConnectedComponentsIdentifier connectedComponentsIdentifier;

    @BeforeEach
    void setup() {
        graph = DirectedGraphBuilder.stronglyConnectedGraph();
        connectedComponentsIdentifier = new KosarajuConnectedComponentsIdentifier(graph);
    }

    @Test
    void stronglyConnected() {
        assertThat(connectedComponentsIdentifier.stronglyConnected(5, 2)).isTrue();
        assertThat(connectedComponentsIdentifier.stronglyConnected(1, 0)).isFalse();
        assertThat(connectedComponentsIdentifier.stronglyConnected(7, 8)).isTrue();
    }

    @Test
    void count() {
        assertThat(connectedComponentsIdentifier.count()).isEqualTo(5);
    }

    @Test
    void id() {
        assertThat(connectedComponentsIdentifier.id(0)).isEqualTo(1);
        assertThat(connectedComponentsIdentifier.id(1)).isEqualTo(0);
        assertThat(connectedComponentsIdentifier.id(6)).isEqualTo(3);
        assertThat(connectedComponentsIdentifier.id(7)).isEqualTo(4);
        assertThat(connectedComponentsIdentifier.id(9)).isEqualTo(2);
    }
}