package com.ynthm.demo.algorithm.fib;

/**
 * 尾递归 有着与 CircleRolling 相同的计算性能， 也有着递归的数学表达能力
 *
 * @author Ethan Wang
 */
public class TailRecursion implements Fibonacci {
  @Override
  public long fib(int n) {
    if (n < 2) {
      return n;
    }
    // 尾递归 Java 不支持命名参数，默认参数值 所以模仿 柯里化
    return fibTail(n, 0L, 1L);
  }

  private long fibTail(int n, long res1, long res2) {
    if (n == 0) {
      return res1;
    }

    return fibTail(n - 1, res2, res1 + res2);
  }
}
