package com.ynthm.demo.algorithm.leet.s70;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q70Test {

  @Test
  void test() {
    Q70 question = new Q70S1();
    assertEquals(1, question.climbStairs(1));
    assertEquals(2, question.climbStairs(2));
    assertEquals(3, question.climbStairs(3));
    assertEquals(5, question.climbStairs(4));
  }
}
