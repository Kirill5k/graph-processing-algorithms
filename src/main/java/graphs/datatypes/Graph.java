package graphs.datatypes;

import java.util.Collection;
import java.util.stream.IntStream;

public interface Graph {
    int vertices();

    int edges();

    void add(Edge edge);

    boolean has(Edge edge);

    Collection<Integer> adjacentTo(int vertex);

    default int degree(int vertex) {
        return adjacentTo(vertex).size();
    }

    default int maxDegree() {
        return IntStream.range(0, vertices())
                .map(this::degree).max()
                .orElseThrow();
    }

    default int averageDegree() {
        return 2 * edges() / vertices();
    }

    default int numberOfSelfLoops() {
        int count = 0;
        for (int vertex = 0; vertex < vertices(); vertex++) {
            for (Integer adjacentVertex : adjacentTo(vertex)) {
                if (adjacentVertex == vertex) {
                    count++;
                }
            }
        }
        return count / 2;
    }

    default String asString() {
        String stringRepr = String.format("%d vertices, %d edges\n", vertices(), edges());
        for (int vertex = 0; vertex < vertices(); vertex++) {
            stringRepr += String.format("%d: ", vertex);
            for (Integer adjacentVertex : adjacentTo(vertex)) {
                stringRepr += String.format("%d ", adjacentVertex);
            }
            stringRepr += "\n";
        }
        return stringRepr;
    }
}
