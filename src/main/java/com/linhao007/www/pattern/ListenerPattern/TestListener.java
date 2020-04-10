package com.linhao007.www.pattern.ListenerPattern;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/11 10:17
 * @description:
 */
public class TestListener {
    public static void main(String[] args) {
        //创建一个事件源
        Person person = new Person();

        //为事件源注册监听
        person.registerListener(new MyPersonListener());
        person.run();
        person.eat();
    }
}
