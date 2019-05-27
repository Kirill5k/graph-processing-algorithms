package graphs.datatypes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UndirectedSymbolGraphTest {
    private SymbolGraph symbolGraph;

    @BeforeEach
    public void setup() {
        symbolGraph = new UndirectedSymbolGraph(List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"));
    }

    @Test
    public void contains() {
        assertThat(symbolGraph.contains("A")).isTrue();
        assertThat(symbolGraph.contains("Z")).isFalse();
    }

    @Test
    public void index() {
        assertThat(symbolGraph.index("A")).isEqualTo(0);
        assertThat(symbolGraph.index("B")).isEqualTo(1);
        assertThat(symbolGraph.index("C")).isEqualTo(2);
        assertThat(symbolGraph.index("K")).isEqualTo(10);
    }

    @Test
    public void name() {
        assertThat(symbolGraph.name(0)).isEqualTo("A");
        assertThat(symbolGraph.name(1)).isEqualTo("B");
        assertThat(symbolGraph.name(2)).isEqualTo("C");
        assertThat(symbolGraph.name(10)).isEqualTo("K");
    }

    @Test
    public void addEdge() {
        symbolGraph.addEdge("A", "B");
        symbolGraph.addEdge("B", "C");
        symbolGraph.addEdge("E", "G");
        symbolGraph.addEdge("C", "F");
        symbolGraph.addEdge("F", "M");
        symbolGraph.addEdge("F", "A");

        assertThat(symbolGraph.adjacentTo("A")).containsExactly(1, 5);
        assertThat(symbolGraph.adjacentTo(0)).containsExactly(1, 5);
    }
}