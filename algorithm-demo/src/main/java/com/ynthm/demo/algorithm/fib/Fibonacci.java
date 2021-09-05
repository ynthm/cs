package com.ynthm.demo.algorithm.fib;

/**
 * 求斐波那契数列第 n 项
 *
 * <p>f(47) 超过 int f(1001) 超过 long
 *
 * @author Ethan Wang
 */
public interface Fibonacci {
  /**
   * F(0)=0 F(1)=1 F(n)= F(n-1)+ F(n-2) n>=2
   *
   * @param n 第 n 项
   * @return F(n)
   */
  long fib(int n);
}
