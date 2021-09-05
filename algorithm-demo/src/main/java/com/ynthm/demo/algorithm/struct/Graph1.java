package com.ynthm.demo.algorithm.struct;

import java.util.ArrayList;
import java.util.List;

/**
 * class to represent a graph object
 *
 * @author Ynthm Wang
 * @version 1.0
 */
public class Graph1 {
  // An array of Lists to represent adjacency list
  List<List<Integer>> adjList = null;

  // Constructor
  Graph1(List<Edge> edges, int N) {
    adjList = new ArrayList<>(N);

    for (int i = 0; i < N; i++) {
      adjList.add(i, new ArrayList<>());
    }

    // add edges to the undirected graph
    for (int i = 0; i < edges.size(); i++) {
      int src = edges.get(i).source;
      int dest = edges.get(i).dest;

      adjList.get(src).add(dest);
      adjList.get(dest).add(src);
    }
  }
}
