package org.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphFactory {
    public static Digraph<Integer> createDiGraphFromTextFile(String path) {
        Digraph<Integer> graph = new Digraph<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int v = Integer.parseInt(parts[0]);
                int w = Integer.parseInt(parts[1]);
                graph.addEdge(v, w, new Edge<>(v, w));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return graph;
    }

    public static WDigraph<Integer> createWDiGraphFromTextFile(String path) {
        WDigraph<Integer> graph = new WDigraph<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int v = Integer.parseInt(parts[0]);
                int w = Integer.parseInt(parts[1]);
                double weight = Double.parseDouble(parts[2]);
                graph.addEdge(v, w, new DirectedEdge(v, w, weight));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return graph;
    }
}
