package com.ynthm.demo.algorithm.struct;

/**
 * Data structure to store graph edges
 *
 * @author Ynthm Wang
 * @version 1.0
 */
public class WeightedEdge {
  int source, dest, weight;

  public WeightedEdge(int source, int dest, int weight) {
    this.source = source;
    this.dest = dest;
    this.weight = weight;
  }
}
