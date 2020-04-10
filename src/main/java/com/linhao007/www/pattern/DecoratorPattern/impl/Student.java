package com.linhao007.www.pattern.DecoratorPattern.impl;

import com.linhao007.www.pattern.DecoratorPattern.Learn;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/4/9 12:02
 * @description: 实现了学习接口的学生,这里是被修饰者的角色
 */
public class Student implements Learn {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void learnSkills() {
        System.out.println(name + "学会了技能:");
    }
}
