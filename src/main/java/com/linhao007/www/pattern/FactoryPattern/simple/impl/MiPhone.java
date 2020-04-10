package com.linhao007.www.pattern.FactoryPattern.simple.impl;

import com.linhao007.www.pattern.FactoryPattern.simple.Phone;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/11 10:35
 * @description:
 */
public class MiPhone implements Phone {
    @Override
    public int getPhoneType() {
        return 0;
    }

    @Override
    public void make() {
        System.out.println("创建小米手机");
    }

}
