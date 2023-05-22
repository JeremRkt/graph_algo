package org.graph;

import java.util.Set;

public class WDigraph<V extends Comparable<V>> extends Graph<V, DirectedEdge> {

    public WDigraph() {
        super();
    }

    @Override
    public V getToVertex(DirectedEdge edge) {
        return edge.to();
    }

    @Override
    public void addEdge(V vertex1, V vertex2, DirectedEdge edge) {
        addVertex(vertex1);
        addVertex(vertex2);

        adjacencyList.get(vertex1).add(edge);
        m++;
    }
    public Set<V> getVertices() {
        return this.adjacencyList.keySet();
    }
    public Set<DirectedEdge> getOutgoingEdges(V vertex) {
        if (!hasVertex(vertex)) {
            throw new IllegalArgumentException("Vectex does not exist in graph");
        }
        return adjacencyList.get(vertex);
    }
}


