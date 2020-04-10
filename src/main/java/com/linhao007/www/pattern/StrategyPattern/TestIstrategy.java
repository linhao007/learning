package com.linhao007.www.pattern.StrategyPattern;

/**
 * Created by www.linhao007.com on 2016-8-31.
 */
public class TestIstrategy {

    private IStrategy iStrategy;

    public TestIstrategy(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    public void operateIstrategy() {
        iStrategy.operate();
    }
}
