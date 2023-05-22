package org.graph;

import java.util.*;

public abstract class Graph<V extends Comparable<V>, E> {
    protected int n;
    protected int m;
    protected Map<V, Set<E>> adjacencyList;


    public Graph(int nbVertices, int nbEdges) {
        this.n = nbVertices;
        this.m = nbEdges;
        this.adjacencyList = new HashMap<>();

    }

    public Graph() {
        this.n = 0;
        this.m = 0;
        this.adjacencyList = new HashMap<>();
    }

    public int order() {
        return n;
    }

    public int size() {
        return m;
    }

    public void addVertex(V vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new HashSet<>());
            n++;
        }
    }

    public List<V> dfs(V startVertex) {
        List<V> visitOrder = new ArrayList<>();
        if (!adjacencyList.containsKey(startVertex)) {
            return visitOrder;
        }

        PriorityQueue<V> priorityQueue = new PriorityQueue<>();
        Set<V> visited = new HashSet<>();
        priorityQueue.add(startVertex);

        while (!priorityQueue.isEmpty()) {
            V currentVertex = priorityQueue.poll();
            if (!visited.contains(currentVertex)) {
                visited.add(currentVertex);
                visitOrder.add(currentVertex);
                for (E edge : adjacencyList.get(currentVertex)) {
                    V toVertex = getToVertex(edge);
                    if (toVertex != null && !visited.contains(toVertex)) {
                        priorityQueue.add(toVertex);
                    }
                }
            }
        }
        return visitOrder;
    }


    public abstract V getToVertex(E edge);

    public abstract void addEdge(V vertex1, V vertex2, E edge);

    public boolean hasVertex(V vertex) {
        return this.adjacencyList.containsKey(vertex);
    }


    public boolean hasEdge(E edge) {
        for (Set<E> edges : this.adjacencyList.values()) {
            if (edges.contains(edge)) {
                return true;
            }
        }
        return false;
    }

    public Set<E> getEdges(V vertex) {
        return this.adjacencyList.get(vertex);
    }


}

