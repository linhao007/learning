package com.linhao007.www.ListenerPattern;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/11 10:17
 * @description: 监听器
 */
public class MyPersonListener implements BaseListener {

    @Override
    public void dorun(Even even) {
        System.out.println("跑之前要记得穿鞋");
    }

    @Override
    public void doeat(Even even) {
        System.out.println("吃之前记得洗手");
    }
}
