package com.ynthm.demo.algorithm.search;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * @author Ynthm
 * @version 1.0
 */
public class FindMedianSorted {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      return findMedianSortedArrays(nums2, nums1);
    }

    int m = nums1.length;
    int n = nums2.length;
    int left = 0, right = m;
    // median1：前一部分的最大值
    // median2：后一部分的最小值
    int median1 = 0, median2 = 0;

    while (left <= right) {
      // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
      // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
      int i = (left + right) / 2;
      int j = (m + n + 1) / 2 - i;

      // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
      int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
      int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
      int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
      int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

      if (nums_im1 <= nums_j) {
        median1 = Math.max(nums_im1, nums_jm1);
        median2 = Math.min(nums_i, nums_j);
        left = i + 1;
      } else {
        right = i - 1;
      }
    }

    return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
  }

  public static void main(String[] args) {
    FindMedianSorted find = new FindMedianSorted();
    int[] nums1 = new int[] {1, 3};
    int[] nums2 = new int[] {2};
    System.out.println(find.findMedianSortedArrays(nums1, nums2));

    int[] nums11 = new int[] {1, 2};
    int[] nums12 = new int[] {3, 4};
    System.out.println(find.findMedianSortedArrays(nums11, nums12));

    int[] nums21 = new int[] {0, 0};
    int[] nums22 = new int[] {0, 0};
    System.out.println(find.findMedianSortedArrays(nums21, nums22));

    int[] nums31 = new int[] {};
    int[] nums32 = new int[] {2};
    System.out.println(find.findMedianSortedArrays(nums31, nums32));
  }
}
