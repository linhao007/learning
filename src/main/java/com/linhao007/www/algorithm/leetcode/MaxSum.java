package com.linhao007.www.algorithm.leetcode;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/2/25 21:15
 * @description:
 */
public class MaxSum {
    /**
     * 求整数数组nums 找到一个具有最大和的连续数组（子数组最少包含一个元素），返回最大和
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];

        for (int i = 1; i < n; ++i) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
