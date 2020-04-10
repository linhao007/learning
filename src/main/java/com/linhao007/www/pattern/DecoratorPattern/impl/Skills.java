package com.linhao007.www.pattern.DecoratorPattern.impl;

import com.linhao007.www.pattern.DecoratorPattern.Learn;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/4/9 12:03
 * @description: 创建装饰角色（Skills）：
 */
public class Skills implements Learn {
    private Learn learner;

    public Skills(Learn learner) {
        this.learner = learner;
    }

    @Override
    public void learnSkills() {
        if (learner != null) {
            learner.learnSkills();
        }
    }
}
