package com.linhao007.www.pattern.SignPattern;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/4/14 11:18
 * @description: 懒汉模式  单例
 */
public final class LazySingleton {

    public static volatile LazySingleton lazySingleton = null;

    public static LazySingleton getInstance() {
        if (null == lazySingleton) {
            synchronized (LazySingleton.class) {
                if (null == lazySingleton) {
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }
}
