package graphs.datatypes.graphs.weight;


import graphs.datatypes.graphs.Edge;

public class WeightedEdge extends Edge implements Comparable<WeightedEdge> {
    private final double weight;

    public WeightedEdge(int from, int to, double weight) {
        super(from, to);
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    @Override
    public int compareTo(WeightedEdge otherEdge) {
        return Double.compare(weight, otherEdge.weight);
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f", from, to, weight);
    }
}
