package graphs.datatypes.weighted;

import graphs.datatypes.Graph;
import graphs.datatypes.simple.SimpleEdge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EdgeWeightedGraphTest {
    private Graph graph;

    @BeforeEach
    void setUp() {
        graph = new EdgeWeightedGraph(20);
    }

    @Test
    public void addEdge() {
        graph.add(new WeightedEdge(0, 5, 1));
        graph.add(new WeightedEdge(1, 5, 1));
        graph.add(new WeightedEdge(2, 5, 1));
        graph.add(new WeightedEdge(3, 5, 1));

        assertThat(graph.edges()).isEqualTo(4);
    }

    @Test
    public void addEdgeSelfLoopAndParallel() {
        graph.add(new WeightedEdge(0, 5, 1));

        assertThrows(IllegalArgumentException.class, () -> graph.add(new WeightedEdge(5, 0, 1)));
        assertThrows(IllegalArgumentException.class, () -> graph.add(new WeightedEdge(0, 0, 1)));
    }

    @Test
    public void addEdgeNotWeightedEdge() {
        assertThrows(IllegalArgumentException.class, () -> graph.add(new SimpleEdge(5, 0)));
    }

    @Test
    public void adjacentTo() {
        graph.add(new WeightedEdge(0, 5, 1));
        graph.add(new WeightedEdge(1, 5, 1));
        graph.add(new WeightedEdge(2, 5, 1));
        graph.add(new WeightedEdge(3, 5, 1));

        assertThat(graph.adjacentTo(5)).containsExactlyInAnyOrder(0, 1, 2, 3);
        assertThat(graph.adjacentTo(0)).containsExactly(5);
    }

    @Test
    public void adjacentEdges() {
        graph.add(new WeightedEdge(0, 5, 1));
        graph.add(new WeightedEdge(1, 5, 1));
        graph.add(new WeightedEdge(2, 5, 1));
        graph.add(new WeightedEdge(3, 5, 1));

        assertThat(graph.adjacentEdges(5)).containsExactlyInAnyOrder(new WeightedEdge(0, 5, 1), new WeightedEdge(1, 5,1), new WeightedEdge(2, 5, 1), new WeightedEdge(3, 5, 1));
        assertThat(graph.adjacentEdges(0)).containsExactly(new WeightedEdge(0, 5, 1));
    }

    @Test
    public void allEdges() {
        graph.add(new WeightedEdge(0, 5, 1));
        graph.add(new WeightedEdge(1, 5, 1));
        graph.add(new WeightedEdge(2, 5, 1));
        graph.add(new WeightedEdge(3, 5, 1));

        assertThat(graph.allEdges()).containsExactlyInAnyOrder(new WeightedEdge(0, 5, 1), new WeightedEdge(1, 5, 1), new WeightedEdge(2, 5, 1), new WeightedEdge(3, 5, 1));
    }

    @Test
    public void degree() {
        graph.add(new WeightedEdge(0, 5, 1));
        graph.add(new WeightedEdge(1, 5, 1));
        graph.add(new WeightedEdge(2, 5, 1));
        graph.add(new WeightedEdge(3, 5, 1));

        assertThat(graph.degree(5)).isEqualTo(4);
        assertThat(graph.degree(0)).isEqualTo(1);
        assertThat(graph.maxDegree()).isEqualTo(4);
    }

    @Test
    public void numberOfSelpfLoops() {
        graph.add(new WeightedEdge(0, 5, 1));
        graph.add(new WeightedEdge(1, 5, 1));
        graph.add(new WeightedEdge(2, 5, 1));
        graph.add(new WeightedEdge(3, 5, 1));

        assertThat(graph.numberOfSelfLoops()).isEqualTo(0);
    }

    @Test
    public void averageDegree() {
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
    public void hasEdge() {
        graph.add(new WeightedEdge(0, 5, 1));

        assertThat(graph.has(new WeightedEdge(0, 5, 1))).isTrue();
        assertThat(graph.has(new WeightedEdge(5, 0, 1))).isTrue();
        assertThat(graph.has(new WeightedEdge(0, 1, 1))).isFalse();
    }

}