package graphs.datatypes.graphs;

import java.util.Collection;

public interface SymbolGraph extends Graph<Edge> {
    boolean contains(String key);
    
    int index(String key);
    
    String name(int vertex);

    void addEdge(String keyFrom, String keyTo);

    Collection<Integer> adjacentTo(String key);
}
