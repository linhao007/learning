package com.linhao007.www.FactoryPattern.simple.impl;

import com.linhao007.www.FactoryPattern.simple.Phone;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/11 10:36
 * @description:
 */
public class ApplePhone implements Phone {
    @Override
    public int getPhoneType() {
        return 0;
    }

    @Override
    public void make() {
        System.out.println("创建苹果手机");
    }
}
