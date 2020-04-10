package com.linhao007.www.pattern.FactoryPattern.simple.impl;

import com.linhao007.www.pattern.FactoryPattern.simple.AbstractFactory;
import com.linhao007.www.pattern.FactoryPattern.simple.Pc;
import com.linhao007.www.pattern.FactoryPattern.simple.Phone;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/11 12:03
 * @description:
 */
public class ApppleFactory implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new ApplePhone();
    }

    @Override
    public Pc makePc() {
        return new ApplePc();
    }
}
