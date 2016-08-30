package com.linhao007.www.CallBackPattern;

import org.junit.Test;

/**
 * Created by www.linhao007.com on 2016-8-27.
 */
public class Client {
    @Test
    public void testCallBackk() {
        Task task = new SimpleTask();
        task.executeWith(task);
    }
}
