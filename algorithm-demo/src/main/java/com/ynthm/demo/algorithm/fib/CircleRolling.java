package com.ynthm.demo.algorithm.fib;

/**
 * 递推 时间复杂度 O(n) 额外空间 O(1)
 *
 * @author Ethan Wang
 */
public class CircleRolling implements Fibonacci {
  @Override
  public long fib(int n) {
    if (n == 0) {
      return 0;
    }

    long a = 0L;
    long b = 1L;
    long c;

    for (int i = 2; i <= n; i++) {
      c = a + b;
      a = b;
      b = c;
    }

    return b;
  }
}
