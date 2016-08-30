package com.linhao007.www.BuildersPattern;

import org.junit.Test;

/**
 * Created by www.linhao007.com on 2016-8-30.
 */
public class PersionTest {

    @Test
    public void testBuilder() {
        Persion persion = new Persion.Builder().
                addSex("man").addName("linhao007").
                addEducation("本科").addAge(18).build();
        System.out.println("建筑者模式创建的persion："+persion.toString());
    }
}
