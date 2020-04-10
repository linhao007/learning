package com.linhao007.www.pattern.DecoratorPattern.impl;

import com.linhao007.www.pattern.DecoratorPattern.Learn;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/4/9 12:05
 * @description:
 */
public class CSkills extends Skills{
    private String skillName;

    public CSkills(Learn learner, String skillName) {
        super(learner);
        this.skillName = skillName;
    }
    public CSkills(Learn learner) {
        super(learner);
    }

    @Override
    public void learnSkills() {
        super.learnSkills();
        System.out.println("    " + skillName);
    }
}
