package com.linhao007.www.FactoryPattern.simple.impl;

import com.linhao007.www.FactoryPattern.simple.AbstractFactory;
import com.linhao007.www.FactoryPattern.simple.Pc;
import com.linhao007.www.FactoryPattern.simple.Phone;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/11 12:02
 * @description:
 */
public class XiaoMiFactory implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }

    @Override
    public Pc makePc() {
        return new MiPc();
    }
}
