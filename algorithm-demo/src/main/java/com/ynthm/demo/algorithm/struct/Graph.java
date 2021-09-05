package com.ynthm.demo.algorithm.struct;

import java.util.ArrayList;
import java.util.List;

/**
 * class to represent a graph object
 *
 * @author Ynthm Wang
 * @version 1.0
 */
public class Graph {
  // A List of Lists to represent an adjacency list
  List<List<WeightedEdge>> adjList = null;

  // Constructor
  Graph(List<WeightedEdge> edges, int N) {
    adjList = new ArrayList<>(N);

    for (int i = 0; i < N; i++) {
      adjList.add(i, new ArrayList<>());
    }

    // add edges to the undirected graph
    for (WeightedEdge edge : edges) {
      adjList.get(edge.source).add(edge);
    }
  }
}
