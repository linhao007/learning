package com.linhao007.www.ChainPattern.impl;

import com.linhao007.www.ChainPattern.Handler;

/**
 * Created by www.linhao007.com on 2016-8-31.
 * 实际责任人员2  负责数字范围1——3
 */
public class assemible1 extends Handler{
    @Override
    public void handleDutyRequest(Integer assemible) {
        if(assemible>=1&&assemible<=3){
            System.out.println("是我的职责1  负责范围为1---3");
        }else{
            if(getSuccessor()!=null){
                getSuccessor().handleDutyRequest(assemible);
            }
        }
    }
}
