package com.ynthm.demo.algorithm.leet.s70;

/**
 * 爬楼梯，每次可以爬1或2个台阶，n阶，有多少种方法到楼顶 dp[n] = dp[n-1] + dp[n-1] dp[0]=1 dp[1]=1
 *
 * @author Ethan Wang
 */
public interface Q70 {
  /**
   * n阶楼梯1步2步走法
   *
   * @param n 阶楼梯
   * @return 多少种方法
   */
  int climbStairs(int n);
}
