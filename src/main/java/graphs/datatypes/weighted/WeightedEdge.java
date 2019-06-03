package graphs.datatypes.weighted;

public class WeightedEdge implements Comparable<WeightedEdge> {
    private final int from;
    private final int to;
    private final double weight;

    public WeightedEdge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int either() {
        return Math.random() > 0.5 ? from : to;
    }

    public double weight() {
        return weight;
    }

    @Override
    public int compareTo(WeightedEdge otherEdge) {
        return Double.compare(weight, otherEdge.weight);
    }
}
