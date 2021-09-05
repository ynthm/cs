package com.ynthm.demo.algorithm.struct;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ynthm Wang
 * @version 1.0
 */
public class Graph2 {
  // An array of Lists to represent adjacency list
  List<List<WeightedEdge>> adjList = null;

  // Constructor
  Graph2(List<WeightedEdge> edges, int N) {
    adjList = new ArrayList<>(N);

    for (int i = 0; i < N; i++) {
      adjList.add(i, new ArrayList<>());
    }
    WeightedEdge edge;
    // add edges to the undirected graph
    for (int i = 0; i < edges.size(); i++) {
      edge = edges.get(i);
      int src = edge.source;
      int dest = edge.dest;

      adjList.get(src).add(edge);
      adjList.get(dest).add(new WeightedEdge(edge.dest, edge.source, edge.weight));
    }
  }
}
