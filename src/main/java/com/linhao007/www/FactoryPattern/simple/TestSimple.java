package com.linhao007.www.FactoryPattern.simple;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/11 10:41
 * @description:
 */
public class TestSimple {
    public static void main(String[] args) {
        PhoneFactory factory = new PhoneFactory();
        factory.getMatchePhone(0).make();
    }
}
