package graphs.datatypes.weighted;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WeightedEdgeTest {

    @Test
    void compareTo() {
        WeightedEdge edge1 = new WeightedEdge(6, 4, 0.51);
        WeightedEdge edge2 = new WeightedEdge(6, 4, 0.1);
        assertThat(edge1).isGreaterThan(edge2);
        assertThat(edge2).isLessThan(edge1);
    }

    @Test
    void toString1() {
        WeightedEdge edge = new WeightedEdge(6, 4, 0.51);
        assertThat(edge.toString()).isEqualTo("6-4 0.51");
    }
}