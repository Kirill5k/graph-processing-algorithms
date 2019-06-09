package graphs.datatypes.graphs.simple;

import graphs.datatypes.graphs.Edge;
import graphs.datatypes.graphs.Graph;
import graphs.datatypes.graphs.SymbolGraph;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndirectedSymbolGraph implements SymbolGraph {
    private final Map<String, Integer> symbolsMap;
    private final String[] keys;
    private final Graph graph;

    public UndirectedSymbolGraph(List<String> keys) {
        this.keys = new String[keys.size()];
        this.graph = new UndirectedGraph(keys.size());
        symbolsMap = new HashMap<>();
        keys.forEach(key -> symbolsMap.put(key, symbolsMap.size()));
        symbolsMap.forEach((key, id) -> this.keys[id] = key);
    }

    @Override
    public boolean contains(String key) {
        return symbolsMap.containsKey(key);
    }

    @Override
    public int index(String key) {
        return symbolsMap.get(key);
    }

    @Override
    public String name(int vertex) {
        return keys[vertex];
    }

    @Override
    public void addEdge(String keyFrom, String keyTo) {
        var edge = new SimpleEdge(symbolsMap.get(keyFrom), symbolsMap.get(keyTo));
        graph.add(edge);
    }

    @Override
    public Collection<Integer> adjacentTo(String key) {
        return graph.adjacentTo(symbolsMap.get(key));
    }

    @Override
    public int vertices() {
        return graph.vertices();
    }

    @Override
    public int edges() {
        return graph.edges();
    }

    public void add(Edge edge) {
        graph.add(edge);
    }

    public boolean has(Edge edge) {
        return graph.has(edge);
    }

    @Override
    public Collection<Integer> adjacentTo(int vertex) {
        return graph.adjacentTo(vertex);
    }

    @Override
    public Collection<Edge> adjacentEdges(int vertex) {
        return graph.adjacentEdges(vertex);
    }

    @Override
    public Collection<Edge> allEdges() {
        return graph.allEdges();
    }
}
