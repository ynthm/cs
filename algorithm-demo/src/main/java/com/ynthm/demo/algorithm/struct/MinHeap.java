package com.ynthm.demo.algorithm.struct;

import com.ynthm.demo.algorithm.util.SortHelper;

/**
 * @author Ynthm
 * @version 1.0
 */
public class MinHeap {

  public void shiftDown(int[] arr, int n, int cur) {
    int child = 2 * cur + 1;
    while (child < n) {
      // 比较左右子树，找到较小值
      if (child + 1 < n && arr[child + 1] < arr[child]) {
        ++child;
        // child时刻保存较小值的下标
      }
      if (arr[child] < arr[cur]) {
        SortHelper.swap(arr, child, cur);
        cur = child;
        child = 2 * cur + 1;
      } else {
        break;
      }
    }
  }

  public void shiftUp(int[] arr, int n, int cur) {
    int parent = (cur - 1) / 2;
    while (cur > 0) {
      if (arr[cur] < arr[parent]) {
        SortHelper.swap(arr, cur, parent);
        cur = parent;
        parent = (cur - 1) / 2;
      } else {
        break;
      }
    }
  }

  public void heapCreate(int[] arr, int n) {
    for (int i = (n - 2) / 2; i >= 0; i--) {
      shiftDown(arr, arr.length, i);
    }
  }

  void heapPush(int[] arr, int val) {
    int[] elementData = new int[arr.length + 1];
    System.arraycopy(arr, 0, elementData, arr.length, 1);
    shiftUp(elementData, elementData.length, elementData.length - 1);
  }

  void heapPop(int[] hp) {
    if (hp.length > 0) {

      SortHelper.swap(hp, 0, hp.length - 1);

      shiftDown(hp, hp.length, 0);
    }
  }
}
