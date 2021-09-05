package com.ynthm.demo.algorithm.struct;

/**
 * @author Ynthm
 * @version 1.0
 */
public class MaxHeap {
  int arr[];
  int currentsize;
  // 默认构造
  public MaxHeap() {
    arr = new int[100]; // 默认大小100
    currentsize = 0;
  }
  // 根据传入的数组批量构造
  public MaxHeap(int[] arr, int n) {
    this.arr = arr;
    // 当前大小为n
    currentsize = n;
    // 建堆
    heapify(n);
  }
  // 插入
  public void insert(int val) {
    arr[currentsize] = val;
    // 向上调整,此时currentsize是当前节点的pos位置
    percolateUp(currentsize);
    // 大小+1
    currentsize++;
  }
  // 删除最大
  public int delMax() {
    // 根节点摘除，更换为末尾节点，再置末尾为0
    int tempmax = arr[0];
    // 最后一个位置的节点
    arr[0] = arr[--currentsize];
    // 下降
    percolateDown(currentsize, 0);
    // 置为0
    arr[currentsize] = 0;
    return tempmax;
  }
  // 建堆
  public void heapify(int n) {
    // 下滤
    for (int i = n / 2 - 1; i >= 0; i--) {
      percolateDown(n, i);
    }
  }
  // 下滤，n是大小，i是下标
  public int percolateDown(int n, int i) {
    int j; // 子节点
    while (i != (j = ProperParent(n, i))) {
      swap(i, j);
      // 换位,将父节点继续往下
      i = j;
    }
    return i; // 返回最后下滤的位置
  }
  // 上滤
  public int percolateUp(int i) {
    // 到达堆顶之前，反复
    while (0 < i) {
      int j = (i - 1) / 2;
      // 适合位置跳出
      if (arr[i] < arr[j]) {
        break;
      }
      swap(i, j); // 换值
      i = j; // i继续往上
    }
    return i;
  }
  // 排序，不断读取根节点就行.low-high区间
  public int[] heapSort() {
    int newarr[] = new int[currentsize];
    int idx = 0;
    while (currentsize != 0) {
      newarr[idx++] = delMax();
    }
    return newarr;
  }
  // 辅助方法
  // 1.当前节点的左右节点谁更大
  public int ProperParent(int n, int i) {
    return RChildValid(n, i)
        ? Bigger(Bigger(i, i * 2 + 1), i * 2 + 2)
        : LChildValid(n, i) ? Bigger(i, i * 2 + 1) : i;
  }
  // 1.1检测是否存在右节点
  public boolean RChildValid(int n, int i) {
    if (i * 2 + 2 < n) {
      return true;
    }
    return false;
  }
  // 1.2检测是否存在左节点
  public boolean LChildValid(int n, int i) {
    if (i * 2 + 1 < n) {
      return true;
    }
    return false;
  }
  // 1.3 对比方法
  public int Bigger(int i, int j) {
    // j存在
    if (j < currentsize) {
      return arr[i] > arr[j] ? i : j;
    }
    return i;
  }

  // 2.交换方法
  public void swap(int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  // 3.遍历
  public void display() {
    for (int i : arr) {
      if (i == 0) {
        break;
      }
      System.out.print(i + " ");
    }
    System.out.println();
  }
  // 测试
  public static void main(String[] args) {
    // 默认构造
    MaxHeap maxhp = new MaxHeap();
    maxhp.insert(16);
    maxhp.insert(59);
    maxhp.insert(4);
    maxhp.insert(28);
    maxhp.insert(44);
    maxhp.insert(31);
    maxhp.insert(32);
    maxhp.insert(14);
    System.out.println("建堆后的数组值：");
    maxhp.display();
    maxhp.delMax();
    System.out.println("删除最大值后的数组值：");
    maxhp.display();

    // 数组批量构造
    int arr[] = {14, 31, 4, 16, 28, 32, 44, 59};
    MaxHeap maxhp2 = new MaxHeap(arr, arr.length);
    System.out.println("建堆后的数组值：");
    maxhp2.display();
    System.out.println("归并排序的数组值：");
    int arr2[] = maxhp2.heapSort();
    for (int j : arr2) {
      System.out.print(j + " ");
    }
  }
}
