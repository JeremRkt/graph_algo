package org.graph;

import java.util.*;

public class Digraph <V extends Comparable<V>> extends Graph<V,Edge<V>> {

    public Digraph(){
        super();
    }

    @Override
    public V getToVertex(Edge<V> edge) {
        return edge.to();
    }

    @Override
    public void addEdge(V vertex1, V vertex2, Edge<V> edge) {
        addVertex(vertex1);
        addVertex(vertex2);

        adjacencyList.get(vertex1).add(edge);
        m++;
    }

    public Set<V> getVertices() {
        return this.adjacencyList.keySet();
    }
    public Set<Edge<V>>getOutgoingEdges(V vertex){
        if (!hasVertex(vertex)){
            throw new IllegalArgumentException("Vertex does not exist in the graph");
        }
        return adjacencyList.get(vertex);
    }
}
