package com.ynthm.demo.algorithm.fib;

/**
 * recursion 递归 n>=40 计算时间明显变长;
 *
 * <p>接近50运行更长时间;
 *
 * <p>int 范围 2^32-1 当 n>46 会溢出
 *
 * @author Ethan Wang
 */
public class Recursion implements Fibonacci {
  @Override
  public long fib(int n) {
    if (n <= 1) {
      return n;
    }

    return fib(n - 1) + fib(n - 2);
  }
}
