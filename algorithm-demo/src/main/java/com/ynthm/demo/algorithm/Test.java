package com.ynthm.demo.algorithm;

import java.util.function.IntFunction;
import java.util.function.LongUnaryOperator;

public class Test {

  public static long factorial(int n) {
    if (n == 1) {
      return 1;
    }
    return n * factorial(n - 1);
  }

  public static long factorial2(int n) {
    return factorialTail(n, 1);
  }

  public static long factorialTail(int n, long total) {
    if (n == 1) {
      return total;
    }
    return factorialTail(n - 1, n * total);
  }

  private static IntFunction<LongUnaryOperator> b = n -> total -> Test.factorialTail(n, total);

  public static void main(String[] args) {
    for (int i = 1; i < 30; i++) {
      System.out.println(factorial(i) + " --- " + b.apply(i).applyAsLong(1L));
    }
  }
}
