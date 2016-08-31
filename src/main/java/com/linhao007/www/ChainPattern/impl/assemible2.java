package com.linhao007.www.ChainPattern.impl;

import com.linhao007.www.ChainPattern.Handler;

/**
 * Created by www.linhao007.com on 2016-8-31.
 * 实际责任人员2  负责数字范围4——6
 */
public class assemible2 extends Handler{
    @Override
    public void handleDutyRequest(Integer assemible) {
        if(assemible>=4&&assemible<=6){
            System.out.println("是我的职责2  负责范围为4---6");
        }else{
            if(getSuccessor()!=null){
                getSuccessor().handleDutyRequest(assemible);
            }
        }
    }
}
