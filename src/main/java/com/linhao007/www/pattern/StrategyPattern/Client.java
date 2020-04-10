package com.linhao007.www.pattern.StrategyPattern;

import com.linhao007.www.pattern.StrategyPattern.impl.IStrategyTest1;
import com.linhao007.www.pattern.StrategyPattern.impl.IStrategyTest2;
import org.junit.Test;

/**
 * Created by www.linhao007.com on 2016-8-31.
 */
public class Client {

    private TestIstrategy testIstrategy;

    @Test
    public void operateTestIstrategy() {
        //创建什么策略   则执行什么策略  策略一
        testIstrategy = new TestIstrategy(new IStrategyTest1());
        testIstrategy.operateIstrategy();

        //策略二
        testIstrategy = new TestIstrategy(new IStrategyTest2());
        testIstrategy.operateIstrategy();
    }
}
