package com.ynthm.demo.algorithm.fib;

/**
 * 带备忘录的递归解法 Memoization
 *
 * @author Ethan Wang
 */
public class MemoizedSolution implements Fibonacci {
  @Override
  public long fib(int n) {
    if (n <= 1) {
      return n;
    }

    long[] memos = new long[n + 1];

    return helper(n, memos);
  }

  private long helper(int n, long[] memos) {
    if (n <= 1) {
      return n;
    }
    if (memos[n] != 0) {
      return memos[n];
    }
    memos[n] = helper(n - 1, memos) + helper(n - 2, memos);

    return memos[n];
  }
}
