package com.linhao007.www.ChainPattern;

import org.junit.Test;

/**
 * Created by www.linhao007.com on 2016-8-31.
 * 客户端调用
 */
public class client {

    @Test
    public void testChain(){
        Handler handler = AssembleChain.getHandlerChain();//构建职责链
        handler.handleDutyRequest(7);//执行职责3
    }
}
