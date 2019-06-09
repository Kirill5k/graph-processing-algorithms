package graphs.datatypes.graphs.simple;

import graphs.datatypes.graphs.Edge;

public class SimpleEdge extends Edge {
    public SimpleEdge(int from, int to) {
        super(from, to);
    }

    @Override
    public String toString() {
        return String.format("%d-%d", from, to);
    }
}
