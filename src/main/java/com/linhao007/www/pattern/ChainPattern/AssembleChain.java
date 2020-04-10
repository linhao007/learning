package com.linhao007.www.pattern.ChainPattern;


import com.linhao007.www.pattern.ChainPattern.impl.assemible1;
import com.linhao007.www.pattern.ChainPattern.impl.assemible2;
import com.linhao007.www.pattern.ChainPattern.impl.assemible3;

/**
 * Created by www.linhao007.com on 2016-7-28.
 * 组装责任链
 * 责任从assemible1到assemible3
 */
public class AssembleChain {

    public static Handler getHandlerChain() {
        Handler h1 = new assemible1();
        Handler h2 = new assemible2();
        Handler h3 = new assemible3();
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);
        return h1;
    }
}
