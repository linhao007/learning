package com.linhao007.www.pattern.SignPattern;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/4/14 11:24
 * @description:饿汉模式
 */
public final class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    /**
     * 自行创建实例
     */
    private HungrySingleton() {
    }

    /**
     * 构造函数
     *
     * @return
     */
    public static HungrySingleton getInstance() {
        //通过该函数向整个系统提供实例
        return instance;
    }

}
