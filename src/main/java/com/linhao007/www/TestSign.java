package com.linhao007.www;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/3 15:00
 * @description:
 */
public class TestSign {
    public static volatile TestSign testSign = null;

    public static TestSign getInstance() {
        if (testSign == null) {
            synchronized (TestSign.class) {
                if (testSign == null) {
                    testSign = new TestSign();
                }

            }
        }
        return testSign;
    }
}
