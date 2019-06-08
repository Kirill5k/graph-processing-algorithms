package graphs.datatypes.simple;

import graphs.datatypes.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DirectedGraphTest {
    private Graph graph;

    @BeforeEach
    void setUp() {
        graph = new DirectedGraph(20);
    }

    @Test
    public void addEdge() {
        graph.add(new SimpleEdge(0, 5));
        graph.add(new SimpleEdge(1, 5));
        graph.add(new SimpleEdge(2, 5));
        graph.add(new SimpleEdge(3, 5));

        assertThat(graph.edges()).isEqualTo(4);
    }

    @Test
    public void addEdgeSelfLoopAndParallel() {
        graph.add(new SimpleEdge(0, 5));

        assertDoesNotThrow(() -> graph.add(new SimpleEdge(5, 0)));
        assertThrows(IllegalArgumentException.class, () -> graph.add(new SimpleEdge(0, 0)));
        assertThrows(IllegalArgumentException.class, () -> graph.add(new SimpleEdge(0, 5)));
    }

    @Test
    public void adjacentTo() {
        graph.add(new SimpleEdge(0, 5));
        graph.add(new SimpleEdge(0, 4));
        graph.add(new SimpleEdge(1, 5));
        graph.add(new SimpleEdge(2, 5));
        graph.add(new SimpleEdge(3, 5));

        assertThat(graph.adjacentTo(5)).isEmpty();
        assertThat(graph.adjacentTo(0)).containsExactlyInAnyOrder(5, 4);
    }

    @Test
    public void degree() {
        graph.add(new SimpleEdge(0, 5));
        graph.add(new SimpleEdge(1, 5));
        graph.add(new SimpleEdge(2, 5));
        graph.add(new SimpleEdge(3, 5));

        assertThat(graph.degree(5)).isEqualTo(0);
        assertThat(graph.degree(0)).isEqualTo(1);
        assertThat(graph.maxDegree()).isEqualTo(1);
    }

    @Test
    public void numberOfSelpfLoops() {
        graph.add(new SimpleEdge(0, 5));
        graph.add(new SimpleEdge(1, 5));
        graph.add(new SimpleEdge(2, 5));
        graph.add(new SimpleEdge(3, 5));

        assertThat(graph.numberOfSelfLoops()).isEqualTo(0);
    }

    @Test
    public void averageDegree() {
        graph.add(new SimpleEdge(0, 5));
        graph.add(new SimpleEdge(1, 5));
        graph.add(new SimpleEdge(2, 5));
        graph.add(new SimpleEdge(3, 5));
        graph.add(new SimpleEdge(4, 6));
        graph.add(new SimpleEdge(6, 10));
        graph.add(new SimpleEdge(10, 0));
        graph.add(new SimpleEdge(11, 2));
        graph.add(new SimpleEdge(2, 8));
        graph.add(new SimpleEdge(8, 9));

        assertThat(graph.averageDegree()).isEqualTo(1);
    }

    @Test
    public void hasEdge() {
        graph.add(new SimpleEdge(0, 5));

        assertThat(graph.has(new SimpleEdge(0, 5))).isTrue();
        assertThat(graph.has(new SimpleEdge(5, 0))).isFalse();
        assertThat(graph.has(new SimpleEdge(0, 1))).isFalse();
    }
}