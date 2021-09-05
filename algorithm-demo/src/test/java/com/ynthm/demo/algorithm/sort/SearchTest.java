package com.ynthm.demo.algorithm.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class SearchTest {

  @Test
  void search() throws UnsupportedEncodingException {
    int[] sortedArr = {3, 4, 5, 6, 7, 8, 9};
    int i = Arrays.binarySearch(sortedArr, 8);
    Assertions.assertEquals(sortedArr[i], 8);
    Assertions.assertEquals(i, 5);

    System.out.println(Integer.toBinaryString('中'));
    System.out.println("中".getBytes("UTF-8").length);
    System.out.println("中".getBytes("UTF-16").length);
  }
}
