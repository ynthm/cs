package com.ynthm.demo.algorithm.struct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HamiltonianPath {

  public static void printAllHamiltonianPaths1(
      Graph2 g, int v, boolean[] visited, List<Integer> path, List<WeightedEdge> edges, int N) {
    // if all the vertices are visited, then
    // hamiltonian path exists
    if (path.size() == N) {
      // print hamiltonian path
      for (int i : path) {
        System.out.print(i + " ");
      }

      System.out.println();
      for (WeightedEdge edge : edges) {
        System.out.println(
            "source: " + edge.source + " dest: " + edge.dest + " distance: " + edge.weight);
      }

      return;
    }

    // Check if every edge starting from vertex v leads
    // to a solution or not
    for (WeightedEdge w : g.adjList.get(v)) {
      // process only unvisited vertices as hamiltonian
      // path visits each vertex exactly once
      if (!visited[w.dest]) {
        visited[w.dest] = true;
        path.add(w.dest);
        edges.add(w);

        // check if adding vertex w to the path leads
        // to solution or not
        printAllHamiltonianPaths1(g, w.dest, visited, path, edges, N);

        // Backtrack
        visited[w.dest] = false;
        path.remove(path.size() - 1);
        edges.remove(path.size() - 1);
      }
    }
  }

  public static void printAllHamiltonianPaths(
      Graph1 g, int v, boolean[] visited, List<Integer> path, int N) {
    // if all the vertices are visited, then
    // hamiltonian path exists
    if (path.size() == N) {
      // print hamiltonian path
      for (int i : path) System.out.print(i + " ");
      System.out.println();

      return;
    }

    // Check if every edge starting from vertex v leads
    // to a solution or not
    for (int w : g.adjList.get(v)) {
      // process only unvisited vertices as hamiltonian
      // path visits each vertex exactly once
      if (!visited[w]) {
        visited[w] = true;
        path.add(w);

        // check if adding vertex w to the path leads
        // to solution or not
        printAllHamiltonianPaths(g, w, visited, path, N);

        // Backtrack
        visited[w] = false;
        path.remove(path.size() - 1);
      }
    }
  }

  private static void weightPath() {
    // List of graph edges as per above diagram
    List<WeightedEdge> edges =
        Arrays.asList(
            new WeightedEdge(0, 1, 4),
            new WeightedEdge(0, 2, 2),
            new WeightedEdge(0, 4, 3),
            new WeightedEdge(1, 3, 5),
            new WeightedEdge(2, 4, 2),
            new WeightedEdge(3, 4, 4));

    // Set number of vertices in the graph
    final int N = 5;

    // create a graph from edges
    Graph2 g = new Graph2(edges, N);

    // starting node
    int start = 0;

    // add starting node to the path
    List<Integer> path = new ArrayList<>();
    path.add(start);

    // mark start node as visited
    boolean[] visited = new boolean[N];
    visited[start] = true;

    List<WeightedEdge> edges1 = new ArrayList<>();

    printAllHamiltonianPaths1(g, start, visited, path, edges1, N);
  }

  private static void paths() {
    // List of graph edges as per above diagram
    List<Edge> edges =
        Arrays.asList(
            new Edge(0, 1),
            new Edge(0, 2),
            new Edge(0, 3),
            new Edge(1, 2),
            new Edge(1, 3),
            new Edge(2, 3));

    // Set number of vertices in the graph
    final int N = 4;

    // create a graph from edges
    Graph1 g = new Graph1(edges, N);

    // starting node
    int start = 0;

    // add starting node to the path
    List<Integer> path = new ArrayList<>();
    path.add(start);

    // mark start node as visited
    boolean[] visited = new boolean[N];
    visited[start] = true;

    printAllHamiltonianPaths(g, start, visited, path, N);
  }

  public static void main(String[] args) {
    weightPath();
  }
}
