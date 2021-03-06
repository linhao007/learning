package com.linhao007.www.algorithm.leetcode;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/2/28 17:23
 * @description:
 */
public class RepeatChat {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int max = 1;

        for (int i = 0; i < chars.length; i++) {
            StringBuilder strTemp = new StringBuilder("");
            strTemp.append(chars[i]);

            int temMax = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (!strTemp.toString().contains(String.valueOf(chars[j]))) {
                    strTemp.append(chars[j]);
                    temMax++;
                } else {
                    break;
                }
            }
            if (temMax > max) {
                max = temMax;
            }
        }
        return max;
    }

    /**
     * 复杂度为o(n)
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring_02(String s) {
        int length = s.length();
        if (length < 1) return 0;
        //记录最大长度
        int maxLen = 1;
        for (int head = 0, tail = 1; tail < s.length(); tail++) {
            char c = s.charAt(tail);
            int index = s.indexOf(c, head);
            if (index < tail) {
                head += (index - head + 1);
            }
            int len = tail - head + 1;
            maxLen = len > maxLen ? len : maxLen;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring_02(str));
    }
}
