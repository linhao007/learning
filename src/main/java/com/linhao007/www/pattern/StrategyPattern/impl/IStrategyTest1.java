package com.linhao007.www.pattern.StrategyPattern.impl;

import com.linhao007.www.pattern.StrategyPattern.IStrategy;

/**
 * Created by www.linhao007.com on 2016-8-31.
 */
public class IStrategyTest1 implements IStrategy{
    public void operate() {
        System.out.println("我是策略一   萌萌哒");
    }
}
