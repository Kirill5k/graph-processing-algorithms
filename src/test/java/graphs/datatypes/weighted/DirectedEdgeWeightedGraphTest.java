package graphs.datatypes.weighted;

import graphs.datatypes.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DirectedEdgeWeightedGraphTest {
    private Graph graph;

    @BeforeEach
    void setUp() {
        graph = new DirectedEdgeWeightedGraph(20);
    }

    @Test
    void addEdge() {
        graph.add(new WeightedEdge(0, 5, 1));
        graph.add(new WeightedEdge(1, 5, 1));
        graph.add(new WeightedEdge(2, 5, 1));
        graph.add(new WeightedEdge(3, 5, 1));

        assertThat(graph.edges()).isEqualTo(4);
    }

    @Test
    void addEdgeSelfLoopAndParallel() {
        graph.add(new WeightedEdge(0, 5, 1));

        assertDoesNotThrow(() -> graph.add(new WeightedEdge(5, 0, 1)));
        assertThrows(IllegalArgumentException.class, () -> graph.add(new WeightedEdge(0, 0, 1)));
    }
    @Test
    void adjacentTo() {
        graph.add(new WeightedEdge(0, 5, 1));
        graph.add(new WeightedEdge(1, 5, 1));
        graph.add(new WeightedEdge(2, 5, 1));
        graph.add(new WeightedEdge(3, 5, 1));

        assertThat(graph.adjacentTo(5)).isEmpty();
        assertThat(graph.adjacentTo(0)).containsExactly(5);
    }

    @Test
    void adjacentEdges() {
        graph.add(new WeightedEdge(0, 5, 1));
        graph.add(new WeightedEdge(1, 5, 1));
        graph.add(new WeightedEdge(2, 5, 1));
        graph.add(new WeightedEdge(3, 5, 1));

        assertThat(graph.adjacentEdges(5)).isEmpty();
        assertThat(graph.adjacentEdges(0)).containsExactly(new WeightedEdge(0, 5, 1));
    }

    @Test
    void allEdges() {
        graph.add(new WeightedEdge(0, 5, 1));
        graph.add(new WeightedEdge(1, 5, 1));
        graph.add(new WeightedEdge(2, 5, 1));
        graph.add(new WeightedEdge(3, 5, 1));

        assertThat(graph.allEdges()).containsExactlyInAnyOrder(new WeightedEdge(0, 5, 1), new WeightedEdge(1, 5, 1), new WeightedEdge(2, 5, 1), new WeightedEdge(3, 5, 1));
    }

    @Test
    void degree() {
        graph.add(new WeightedEdge(0, 5, 1));
        graph.add(new WeightedEdge(1, 5, 1));
        graph.add(new WeightedEdge(2, 5, 1));
        graph.add(new WeightedEdge(3, 5, 1));

        assertThat(graph.degree(5)).isEqualTo(0);
        assertThat(graph.degree(0)).isEqualTo(1);
        assertThat(graph.maxDegree()).isEqualTo(1);
    }

    @Test
    void numberOfSelpfLoops() {
        graph.add(new WeightedEdge(0, 5, 1));
        graph.add(new WeightedEdge(1, 5, 1));
        graph.add(new WeightedEdge(2, 5, 1));
        graph.add(new WeightedEdge(3, 5, 1));

        assertThat(graph.numberOfSelfLoops()).isEqualTo(0);
    }

    @Test
    void averageDegree() {
        graph.add(new WeightedEdge(0, 5, 1));
        graph.add(new WeightedEdge(1, 5, 1));
        graph.add(new WeightedEdge(2, 5, 1));
        graph.add(new WeightedEdge(3, 5, 1));
        graph.add(new WeightedEdge(4, 6, 1));
        graph.add(new WeightedEdge(6, 10, 1));
        graph.add(new WeightedEdge(10, 0, 1));
        graph.add(new WeightedEdge(11, 2, 1));
        graph.add(new WeightedEdge(2, 8, 1));
        graph.add(new WeightedEdge(8, 9, 1));

        assertThat(graph.averageDegree()).isEqualTo(1);
    }

    @Test
    void hasEdge() {
        graph.add(new WeightedEdge(0, 5, 1));

        assertThat(graph.has(new WeightedEdge(0, 5, 1))).isTrue();
        assertThat(graph.has(new WeightedEdge(5, 0, 1))).isFalse();
        assertThat(graph.has(new WeightedEdge(0, 1, 1))).isFalse();
    }
}