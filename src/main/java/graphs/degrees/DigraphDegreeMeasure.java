package graphs.degrees;

import graphs.datatypes.graphs.simple.DirectedGraph;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class DigraphDegreeMeasure extends DegreeMeasure {
    private final int[] outdegrees;
    private final int[] indegrees;

    private final List<Integer> sources;
    private final List<Integer> sinks;

    public DigraphDegreeMeasure(DirectedGraph graph) {
        super(graph);
        outdegrees = new int[graph.vertices()];
        indegrees = new int[graph.vertices()];
        for (int vertex = 0; vertex < graph.vertices(); vertex++) {
            indegrees[vertex] = 0;
        }

        for (int vertex = 0; vertex < graph.vertices(); vertex++) {
            outdegrees[vertex] = graph.adjacentTo(vertex).size();
            for (int adjacentVertex : graph.adjacentTo(vertex)) {
                indegrees[adjacentVertex] += 1;
            }
        }

        sinks = verticesWith0Degree(outdegrees);
        sources = verticesWith0Degree(indegrees);
    }

    private List<Integer> verticesWith0Degree(int[] degrees) {
        return IntStream.range(0, graph.vertices())
                .filter(vertex -> degrees[vertex] == 0)
                .boxed()
                .collect(toList());
    }

    @Override
    public int indegree(int vertex) {
        return indegrees[vertex];
    }

    @Override
    public int outdegree(int vertex) {
        return outdegrees[vertex];
    }

    @Override
    public List<Integer> sources() {
        return sources;
    }

    @Override
    public List<Integer> sinks() {
        return sinks;
    }

    @Override
    public boolean isMap() {
        return Arrays.stream(outdegrees)
                .allMatch(degree -> degree == 1);
    }

    @Override
    public boolean hasEulerianCycle() {
        return IntStream.range(0, graph.vertices())
                .allMatch(vertex -> indegrees[vertex] == outdegrees[vertex]);
    }
}
