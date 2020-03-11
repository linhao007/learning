package com.linhao007.www.FactoryPattern.simple.impl;

import com.linhao007.www.FactoryPattern.simple.Pc;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/11 12:00
 * @description:
 */
public class MiPc implements Pc{
    @Override
    public void maske() {
        System.out.println("生产小米PC");
    }
}
