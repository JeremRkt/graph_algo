package org.graph;

import java.util.Set;

public class WDigraph<V extends Comparable<V>> extends Graph<Integer, DirectedEdge> {

    public WDigraph() {
        super();
    }
    @Override
    public Integer getToVertex(DirectedEdge edge) {
        return edge.to();
    }

    @Override
    public void addEdge(Integer vertex1, Integer vertex2, DirectedEdge edge) {
        addVertex(vertex1);
        addVertex(vertex2);

        adjacencyList.get(vertex1).add(edge);
        m++;
    }
    
    public Set<Integer> getVertices() {
        return this.adjacencyList.keySet();
    }
    public Set<DirectedEdge> getOutgoingEdges(Integer vertex) {
        if (!hasVertex(vertex)) {
            throw new IllegalArgumentException("Vectex does not exist in graph");
        }
        return adjacencyList.get(vertex);
    }

}


