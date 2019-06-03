package graphs.datatypes.simple;

import graphs.datatypes.Edge;
import graphs.datatypes.Graph;

import java.util.*;

public class DirectedGraph implements Graph {
    private final int vertices;
    private int edges;
    private final List<Integer>[] adjacencyLists;

    public DirectedGraph(int vertices) {
        this.vertices = vertices;
        this.edges = 0;
        this.adjacencyLists = (List<Integer>[]) new List[vertices];
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
        return edges;
    }

    public void add(Edge edge) {
        if (edge.isSelfloop() || has(edge)) {
            throw new IllegalArgumentException("parallel edges and self-loops are not allowed");
        }

        adjacencyLists[edge.from()].add(edge.to());
        edges++;
    }

    public boolean has(Edge edge) {
        return adjacencyLists[edge.from()].contains(edge.to());
    }

    /**
     * get vertices connected to vertex by edges pointing from vertex
     * @param vertex
     * @return list of vertices
     */
    @Override
    public Collection<Integer> adjacentTo(int vertex) {
        return adjacencyLists[vertex];
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
