package graphs.datatypes.weighted;

import graphs.datatypes.Edge;

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
}
