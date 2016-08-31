package com.linhao007.www.ChainPattern.impl;

import com.linhao007.www.ChainPattern.Handler;

/**
 * Created by www.linhao007.com on 2016-8-31.
 * 实际责任人员3  负责数字范围7——10
 */
public class assemible3 extends Handler{
    @Override
    public void handleDutyRequest(Integer assemible) {
        if(assemible>=7&&assemible<=10){
            System.out.println("是我的职责3  负责范围为7---10");
        }else{
            if(getSuccessor()!=null){
                getSuccessor().handleDutyRequest(assemible);
            }
        }
    }
}
