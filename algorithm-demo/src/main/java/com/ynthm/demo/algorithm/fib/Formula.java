package com.ynthm.demo.algorithm.fib;

/** @author Ethan Wang */
public class Formula implements Fibonacci {
  @Override
  public long fib(int n) {

    if (n < 2) {
      return n;
    }
    double sqrtFive = Math.sqrt(5);

    // 最大值 4 124 817 371 235 594 752
    return Math.round(
        (Math.pow(0.5 + sqrtFive / 2, n) - Math.pow(0.5 - sqrtFive / 2, n)) / sqrtFive);
  }
}
