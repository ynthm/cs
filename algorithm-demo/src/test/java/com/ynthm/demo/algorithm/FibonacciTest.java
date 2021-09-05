package com.ynthm.demo.algorithm;

import com.ynthm.demo.algorithm.fib.*;
import com.ynthm.demo.algorithm.util.StopWatch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class FibonacciTest {

  @Test
  void test() {
    Fibonacci fib = new Recursion();
    assertEquals(0, fib.fib(0));
    assertEquals(1, fib.fib(1));
    assertEquals(1, fib.fib(2));
    assertEquals(2, fib.fib(3));
    assertEquals(3, fib.fib(4));
    assertEquals(5, fib.fib(5));
    assertEquals(8, fib.fib(6));
    assertEquals(13, fib.fib(7));
    assertEquals(21, fib.fib(8));
    assertEquals(102334155L, fib.fib(40));
    // 递归 n>=40 计算时间明显变长
    assertEquals(1134903170L, fib.fib(45));
  }

  @Test
  void fibMemoTest() throws Exception {
    extracted(new MemoizedSolution());
  }

  @Test
  void fibDpTableTest() throws Exception {
    Fibonacci fib = new TabulatedSolution();
    extracted(fib);
  }

  @Test
  void fibTest() throws Exception {
    Fibonacci fib = new CircleRolling();
    extracted(fib);
  }

  /** O(logn) O(1) */
  @Test
  void testFormula() {
    Fibonacci fib = new Formula();
    Fibonacci fib1 = new TabulatedSolution();
    // 最多精确到 70
    for (int i = 0; i < 71; i++) {
      System.out.println(i + ": " + fib.fib(i));
      assertEquals(fib1.fib(i), fib.fib(i));
    }

    assertNotEquals(fib1.fib(71), fib.fib(71));
  }

  @Test
  void testTabulatedSolution() throws Exception {
    Fibonacci tailRecursion = new TailRecursion();
    extracted(tailRecursion);
  }

  private void extracted(Fibonacci fib) throws Exception {
    StopWatch stopWatch = new StopWatch();
    try (StopWatch ignored = stopWatch.start("001")) {
      assertEquals(0, fib.fib(0));
      assertEquals(1, fib.fib(1));
      assertEquals(1, fib.fib(2));
      assertEquals(2, fib.fib(3));
      assertEquals(3, fib.fib(4));
      assertEquals(5, fib.fib(5));
      assertEquals(8, fib.fib(6));
      assertEquals(13, fib.fib(7));
      assertEquals(21, fib.fib(8));

      assertEquals(1134903170L, fib.fib(45));
      assertEquals(12586269025L, fib.fib(50));
      assertEquals(23416728348467685L, fib.fib(80));
      assertEquals(2880067194370816120L, fib.fib(90));
      assertEquals(4660046610375530309L, fib.fib(91));
      assertEquals(7540113804746346429L, fib.fib(92));
    }
    System.out.println(stopWatch.toString1());
  }
}
