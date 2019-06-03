package graphs.datatypes.simple;


import graphs.datatypes.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UndirectedGraphTest {
    private Graph graph;

    @BeforeEach
    void setUp() {
        graph = new UndirectedGraph(20);
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

        assertThrows(IllegalArgumentException.class, () -> graph.add(new SimpleEdge(5, 0)));
        assertThrows(IllegalArgumentException.class, () -> graph.add(new SimpleEdge(0, 0)));
    }

    @Test
    public void adjacentTo() {
        graph.add(new SimpleEdge(0, 5));
        graph.add(new SimpleEdge(1, 5));
        graph.add(new SimpleEdge(2, 5));
        graph.add(new SimpleEdge(3, 5));

        assertThat(graph.adjacentTo(5)).containsExactlyInAnyOrder(0, 1, 2, 3);
        assertThat(graph.adjacentTo(0)).containsExactly(5);
    }

    @Test
    public void degree() {
        graph.add(new SimpleEdge(0, 5));
        graph.add(new SimpleEdge(1, 5));
        graph.add(new SimpleEdge(2, 5));
        graph.add(new SimpleEdge(3, 5));

        assertThat(graph.degree(5)).isEqualTo(4);
        assertThat(graph.degree(0)).isEqualTo(1);
        assertThat(graph.maxDegree()).isEqualTo(4);
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
        assertThat(graph.has(new SimpleEdge(5, 0))).isTrue();
        assertThat(graph.has(new SimpleEdge(0, 1))).isFalse();
    }
}