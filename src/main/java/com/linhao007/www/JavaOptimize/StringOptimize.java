package com.linhao007.www.JavaOptimize;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/4/11 10:35
 * @description:
 */
public class StringOptimize {
    public static void main(String[] args) {
        //intern  会去常量池中查找是否存在该字符串   有的话   直接返回常量池的地址  所以这两个是相等的  节约内存
        String str_01 = new String("abc").intern();
        String str_02 = new String("abc").intern();
        System.out.println(str_01==str_02);

        //当不区分大小写的时候  indexOf的效率比contains高  如果是中文 contains的效率要更高点。

    }
}
