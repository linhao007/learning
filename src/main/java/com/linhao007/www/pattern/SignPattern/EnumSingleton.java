package com.linhao007.www.pattern.SignPattern;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/4/14 11:27
 * @description:枚举模式的单例
 */
public class EnumSingleton {
    private EnumSingleton() {
    }

    public static EnumSingleton getInstance() {
        return Sinleton.SIGNLE.getInstance();
    }

    private enum Sinleton {
        SIGNLE;
        private EnumSingleton singleton;

        /**
         * JVM保证这个方法只调用一次
         */
        Sinleton() {
            singleton = new EnumSingleton();
        }

        public EnumSingleton getInstance() {
            return singleton;
        }
    }
}
