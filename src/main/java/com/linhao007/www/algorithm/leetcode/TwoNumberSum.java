package com.linhao007.www.algorithm.leetcode;

import java.util.HashMap;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/2/25 21:20
 * @description:
 */
public class TwoNumberSum {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
     * 并返回他们的数组下标。
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMaps = new HashMap<Integer, Integer>(nums.length);
        int[] d = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (numMaps.containsKey(nums[i])) {
                d[0] = numMaps.get(nums[i]);
                d[1] = i;
                return d;
            }
            numMaps.put(target - nums[i], i);
        }
        return d;
    }
}
