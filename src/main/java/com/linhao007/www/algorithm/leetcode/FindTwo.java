package com.linhao007.www.algorithm.leetcode;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/4 21:36
 * @description: 根据二维数组  查找某个数  存在返回true   不存在返回false
 */
public class FindTwo {
    public static boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        //行数
        int rows = array.length;
        //列数
        int columns = array[0].length;
        //如果目标值大于最大数 或最小数  则返回未找到
        if (target > array[rows - 1][columns - 1] || target < array[0][0]) {
            return false;
        }
        rows = 0;
        for (int i = columns - 1; i >= 0 && rows < array.length; ) {
            if (array[rows][i] == target) {
                return true;
            } else if (array[rows][i] > target) {
                i--;
            } else if (array[rows][i] < target) {
                rows++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 3, 5, 7}, {2, 4, 6, 8}, {9, 11, 13, 15}};
        int target = 15;
        System.out.println(Find(target, array));
        System.out.println(Find(16, new int[][]{{}}));
    }
}
