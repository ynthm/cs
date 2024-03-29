package com.ynthm.demo.algorithm.s53;

/**
 * dp[i] 的值只和 dp[i-1] 有关，可以使用 滚动变量 的方式优化
 *
 * @author Ethan Wang
 */
public class Solution53T2 implements Solution53 {
  @Override
  public int maxSubArray(int[] nums) {
    int len = nums.length;
    // dp[i] 表示以 nums[i] 结尾的连续子数组的最大和
    int[] dp = new int[len];
    dp[0] = nums[0];
    int res = dp[0];
    for (int i = 1; i < len; i++) {
      dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
      res = Math.max(res, dp[i]);
    }

    return res;
  }
}
