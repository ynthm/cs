package com.ynthm.demo.algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Ynthm
 * @version 1.0
 */
class HeapSortTest {

  @Test
  void test() {
    HeapSort heapSort = new HeapSort();
    int[] sorted = heapSort.sort(new int[] {2, 3, 4, 8, 6, 3, 1});
    heapSort.sort2(new int[] {2, 3, 4, 8, 6, 3, 1});
    Arrays.stream(sorted).forEach(System.out::println);
  }
}
