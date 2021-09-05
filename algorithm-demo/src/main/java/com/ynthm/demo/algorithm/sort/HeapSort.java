package com.ynthm.demo.algorithm.sort;

import com.ynthm.demo.algorithm.util.SortHelper;

/** @author ynthm */
public class HeapSort {

  /** 声明全局变量，用于记录数组array的长度； */
  static int len;

  /**
   * 堆排序算法
   *
   * @param array
   * @return
   */
  public int[] sort(int[] array) {
    len = array.length;
    if (len < 1) {
      return array;
    }
    // 构建一个最大堆
    buildMaxHeap(array);
    // 循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
    while (len > 0) {
      SortHelper.swap(array, 0, len - 1);
      len--;
      adjustHeap(array, 0);
    }
    return array;
  }

  public int[] sort2(int[] array) {
    len = array.length;
    if (len < 2) {
      return array;
    }
    // 构建一个最大堆
    makeMinHeap(array, len);
    // 循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
    while (len > 0) {
      SortHelper.swap(array, 0, len - 1);
      len--;
      minHeapFixdown(array, 0, len);
    }
    return array;
  }

  /**
   * 建立最大堆
   *
   * @param array
   */
  public void buildMaxHeap(int[] array) {
    // 从最后一个非叶子节点开始向上构造最大堆
    for (int i = (len / 2 - 1); i >= 0; i--) {
      adjustHeap(array, i);
    }
  }
  /**
   * 调整使之成为最大堆
   *
   * @param array
   * @param i
   */
  public void adjustHeap(int[] array, int i) {
    int maxIndex = i;
    // 如果有左子树，且左子树大于父节点，则将最大指针指向左子树
    if (i * 2 < len && array[i * 2] > array[maxIndex]) {
      maxIndex = i * 2;
    }
    // 如果有右子树，且右子树大于父节点，则将最大指针指向右子树
    if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex]) {
      maxIndex = i * 2 + 1;
    }
    // 如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
    if (maxIndex != i) {
      SortHelper.swap(array, maxIndex, i);
      adjustHeap(array, maxIndex);
    }
  }

  // 建立最小堆
  void makeMinHeap(int a[], int n) {
    for (int i = n / 2 - 1; i >= 0; i--) {
      minHeapFixdown(a, i, n);
    }
  }

  //  从i节点开始调整,n为节点总数 从0开始计算 i节点的子节点为 2*i+1, 2*i+2
  private void minHeapFixdown(int a[], int i, int n) {
    int j, temp;

    temp = a[i];
    j = 2 * i + 1;
    while (j < n) {
      if (j + 1 < n && a[j + 1] < a[j]) // 在左右孩子中找最小的
      {
        j++;
      }

      if (a[j] >= temp) {
        break;
      }

      a[i] = a[j]; // 把较小的子结点往上移动,替换它的父结点
      i = j;
      j = 2 * i + 1;
    }
    a[i] = temp;
  }

  /*
   * 堆排序
   * 调整最大堆，交换根元素和最后一个元素。
   * 参数说明：
   *     a -- 待排序的数组
   */
  public static void sort1(int[] a) {
    int n = a.length;
    int i, tmp;
    // 从(n/2-1) --> 0逐次遍历。遍历之后，得到的数组实际上是一个(最大)二叉堆。
    for (i = n / 2 - 1; i >= 0; i--) {
      maxHeapDown(a, i, n - 1);
    }
    // 从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
    for (i = n - 1; i > 0; i--) {
      // 交换a[0]和a[i]。交换后，a[i]是a[0...i]中最大的。
      tmp = a[0];
      a[0] = a[i];
      a[i] = tmp;
      // 调整a[0...i-1]，使得a[0...i-1]仍然是一个最大堆。
      // 即，保证a[i-1]是a[0...i-1]中的最大值。
      maxHeapDown(a, 0, i - 1);
    }
  }
  /*
   * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
   *     其中，N为数组下标索引值，如数组中第1个数对应的N为0。
   *
   * 参数说明：
   *     a -- 待排序的数组
   *     start -- 被下调节点的起始位置(一般为0，表示从第1个开始)
   *     end   -- 截至范围(一般为数组中最后一个元素的索引)
   */
  public static void maxHeapDown(int[] a, int start, int end) {
    int c = start; // 当前(current)节点的位置
    int l = 2 * c + 1; // 左(left)孩子的位置
    int tmp = a[c]; // 当前(current)节点的大小
    for (; l <= end; c = l, l = 2 * l + 1) {
      // "l"是左孩子，"l+1"是右孩子
      if (l < end && a[l] < a[l + 1]) {
        l++; // 左右两孩子中选择较大者，即m_heap[l+1]
      }
      if (tmp >= a[l]) {
        break; // 调整结束
      } else { // 交换值
        a[c] = a[l];
        a[l] = tmp;
      }
    }
  }
}
