package com.linhao007.www.FactoryPattern.simple;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/11 11:58
 * @description:
 */
public interface AbstractFactory {
    Phone makePhone();

    Pc makePc();
}
