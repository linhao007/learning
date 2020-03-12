package com.linhao007.www.algorithm.leetcode;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/12 16:44
 * @description: 版本号比对 比较两个版本号 version1 和 version2。
 */
public class CompileVersion {
    public static int compileVersion(String version_01, String version_02) {
        String[] str_01 = version_01.split("\\.");
        String[] str_02 = version_02.split("\\.");

        for (int n = 0; n < Math.max(str_01.length, str_02.length); n++) {

            //取当前位数进行比较  当不在这个长度以内  以0来填充
            int i = n < str_01.length ? Integer.valueOf(str_01[n]) : 0;

            int j = n < str_02.length ? Integer.valueOf(str_02[2]) : 0;


            if (i < j) {
                return -1;
            } else {
                if (i > j) {
                    return 1;
                }
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compileVersion("1.2.3.2", "1.2.3.5"));
    }
}
