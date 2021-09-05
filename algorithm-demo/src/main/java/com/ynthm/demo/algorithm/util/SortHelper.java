package com.ynthm.demo.algorithm.util;

/** @author ynthm */
public class SortHelper {

  private SortHelper() {}

  /**
   * 交换数组array的i和j位置的数据
   *
   * @param array 数组
   * @param i 下标i
   * @param j 下标j
   */
  public static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
