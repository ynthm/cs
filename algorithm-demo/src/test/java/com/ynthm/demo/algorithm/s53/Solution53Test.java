package com.ynthm.demo.algorithm.s53;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution53Test {

  @Test
  void test1() {
    Solution53 solution = new Solution53T1();
    test(solution);
  }

  @Test
  void test2() {
    Solution53 solution = new Solution53T2();
    test(solution);
  }

  private void test(Solution53 solution) {
    assertEquals(6, solution.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    assertEquals(1, solution.maxSubArray(new int[] {1}));
    assertEquals(-1, solution.maxSubArray(new int[] {-1}));
  }
}
