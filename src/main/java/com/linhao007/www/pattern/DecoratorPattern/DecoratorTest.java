package com.linhao007.www.pattern.DecoratorPattern;

import com.linhao007.www.pattern.DecoratorPattern.impl.CSkills;
import com.linhao007.www.pattern.DecoratorPattern.impl.Skills;
import com.linhao007.www.pattern.DecoratorPattern.impl.Student;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/4/9 12:07
 * @description:
 */
public class DecoratorTest {
    public static void main(String[] args) {
        // 创建学生“小明”
        Learn xiaoming = new Student("小明");
        // 创建修饰者“skills”
        Skills skills = new Skills(xiaoming);
        // 多层修饰skill
        // 即模拟小明多次学习新技能
        skills = new CSkills(skills, "Java");
        skills = new CSkills(skills, "Python");
        skills = new CSkills(skills, "Hadoop");
        // 输出小明的技能
        skills.learnSkills();
    }
}
