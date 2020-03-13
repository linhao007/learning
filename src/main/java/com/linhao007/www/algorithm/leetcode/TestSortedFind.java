package com.linhao007.www.algorithm.leetcode;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/13 11:38
 * @description:查找有序数组中某个数首次出现的位置
 */
public class TestSortedFind {

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 3, 4, 5, 6};
        System.out.println(findNumber(a, 3));

    }

    public static int findNumber(int[] a, int key) {
        //最低位
        int low = 0;

        //最高位
        int high = a.length - 1;

        while (low <= high) {
            //取中间值 查找
            int mid = (low + high) / 2;

            if (a[mid] == key && a[mid - 1] != key) {
                return mid;
            } else if (a[mid] >= key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
