package com.ynthm.demo.algorithm.leet.s70;

public class Q70S1 implements Q70 {
  @Override
  public int climbStairs(int n) {
    int p;
    int q = 1;
    int r = 1;

    for (int i = 2; i <= n; i++) {
      p = q;
      q = r;
      r = p + q;
    }

    return r;
  }
}
