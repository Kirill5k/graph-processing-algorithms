package graphs.datatypes;

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
}
