package com.ynthm.demo.algorithm.s53;

/**
 * dp[i] 的值只和 dp[i-1] 有关，可以使用 滚动变量 的方式优化
 *
 * @author Ethan Wang
 */
public class Solution53T1 implements Solution53 {
  @Override
  public int maxSubArray(int[] nums) {
    int maxAns = Integer.MIN_VALUE;
    int pre = 0;
    for (int num : nums) {
      pre = Math.max(num, pre + num);
      maxAns = Math.max(pre, maxAns);
    }

    return maxAns;
  }
}
