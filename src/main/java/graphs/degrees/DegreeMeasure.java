package graphs.degrees;

import graphs.datatypes.Graph;

import java.util.List;

public abstract class DegreeMeasure {
    protected final Graph graph;

    public DegreeMeasure(Graph graph) {
        this.graph = graph;
    }

    public abstract int indegree(int vertex);

    public abstract int outdegree(int vertex);

    public abstract List<Integer> sources();

    public abstract List<Integer> sinks();

    public abstract boolean isMap();

    public abstract boolean hasEulerianCycle();
}