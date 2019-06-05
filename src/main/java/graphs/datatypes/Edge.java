package graphs.datatypes;

import java.util.Objects;

public abstract class Edge {
    protected final int from;
    protected final int to;

    protected Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public boolean isSelfloop() {
        return to == from;
    }

    public int to() {
        return to;
    }

    public int from() {
        return from;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return from == edge.from && to == edge.to ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
