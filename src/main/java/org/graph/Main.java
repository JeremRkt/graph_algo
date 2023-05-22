package org.graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

//        Digraph<Integer> graph = new Digraph<>();
//
//
//        for (int i = 1; i <= 7; i++) {
//            graph.addVertex(i);
//        }
//
//        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/graph-WDG.txt"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] parts = line.split(" ");
//                int v = Integer.parseInt(parts[0]);
//                int w = Integer.parseInt(parts[1]);
//                Edge<Integer> edge = new Edge<>(v, w);
//                graph.addEdge(v, w, edge);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        for (Integer vertex : graph.getVertices()) {
//            System.out.println("Outgoing edges for vertex " + vertex + ":");
//            for (Edge<Integer> edge : graph.getOutgoingEdges(vertex)) {
//                System.out.println("From " + edge.from() + " to " + edge.to());
//            }
//        }


        //--------------------*Weighted digraphs*-----------------------//
        WDigraph<Integer> graph1 = new WDigraph<>();

        // Add vertices to the graph
        for (int i = 1; i <= 7; i++) {
            graph1.addVertex(i);
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/graph-WDG.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int v = Integer.parseInt(parts[0]);
                int w = Integer.parseInt(parts[1]);
                double weight = Double.parseDouble(parts[2]);
                graph1.addEdge(v, w, new DirectedEdge(v, w, weight));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Integer vertex : graph1.getVertices()) {
            System.out.println("Outgoing edges for vertex " + vertex + ":");
            for (DirectedEdge edge : graph1.getOutgoingEdges(vertex)) {
                System.out.println("From " + edge.from() + " to " + edge.to() + " with weight " + edge.weight());
            }
        }


        //----------------------------DFS---------------------------------//

        Digraph<Integer> graph = GraphFactory.createDiGraphFromTextFile("src/main/resources/graph-DFS-BFS.txt");
        List<Integer> dfsOrder = graph.dfs(5);
        System.out.println("\nOrder of first encounter of nodes in DFS: " + dfsOrder);
    }
}
