package com.linhao007.www.pattern.ChainPattern;


/**
 * Created by www.linhao007.com on 2016-7-28.
 * 责任链模式  抽象处理者角色
 */
public abstract class Handler {
    /**
     * 持有下一个处理请求的职责对象
     */
    protected Handler successor = null;

    /**
     * 取职责对象方法
     */
    public Handler getSuccessor() {
        return successor;
    }

    /**
     * 设置下一个处理请求的职责对象
     */
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    /**
     * 判断该数据是否处于该对象职责中   是的话  处理并发相应的邮件推进   否的话  将职责往下传递
     * @return
     */
    public abstract void handleDutyRequest(Integer assemible);
}
