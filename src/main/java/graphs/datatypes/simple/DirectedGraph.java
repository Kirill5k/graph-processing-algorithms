package graphs.datatypes.simple;

import graphs.datatypes.Edge;
import graphs.datatypes.Graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class DirectedGraph implements Graph<Edge> {
    private final int vertices;
    private List<Edge> edges;
    private final List<Edge>[] adjacencyLists;

    public DirectedGraph(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
        this.adjacencyLists = (List<Edge>[]) new List[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyLists[i] = new ArrayList<>();
        }
    }

    @Override
    public int vertices() {
        return vertices;
    }

    @Override
    public int edges() {
        return edges.size();
    }

    public void add(Edge edge) {
        if (edge.isSelfloop() || has(edge)) {
            throw new IllegalArgumentException("parallel edges and self-loops are not allowed");
        }

        adjacencyLists[edge.from()].add(edge);
        edges.add(edge);
    }

    public boolean has(Edge edge) {
        return adjacencyLists[edge.from()].contains(edge);
    }

    /**
     * get vertices connected to vertex by edges pointing from vertex
     * @param vertex
     * @return list of vertices
     */
    @Override
    public Collection<Integer> adjacentTo(int vertex) {
        return adjacencyLists[vertex].stream()
                .map(Edge::to)
                .collect(toList());
    }

    @Override
    public Collection<Edge> adjacentEdges(int vertex) {
        return adjacencyLists[vertex];
    }

    @Override
    public Collection<Edge> allEdges() {
        return edges;
    }

    public DirectedGraph reverse() {
        DirectedGraph reversedGraph = new DirectedGraph(vertices);
        for (int vertex = 0; vertex < vertices; vertex++) {
            for (int adjacentVertex : adjacentTo(vertex)) {
                reversedGraph.add(new SimpleEdge(adjacentVertex, vertex));
            }
        }
        return reversedGraph;
    }
}
