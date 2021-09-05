package com.ynthm.demo.algorithm.fib;

/**
 * 动态规划 DP table
 *
 * @author Ethan Wang
 */
public class TabulatedSolution implements Fibonacci {
  @Override
  public long fib(int n) {
    if (n <= 1) {
      return n;
    }

    long[] table = new long[n + 1];

    table[1] = 1;
    table[2] = 1;
    for (int i = 3; i <= n; i++) {
      table[i] = table[i - 1] + table[i - 2];
    }

    return table[n];
  }
}
