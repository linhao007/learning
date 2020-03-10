package com.linhao007.www.current;

import java.util.concurrent.*;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/5 18:25
 * @description:
 */
public class CountDownLanuth {
//    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(30, 100, 60,
//            TimeUnit.SECONDS, new LinkedBlockingQueue<>(500));
//
//    public Integer callFast() {
//        final int a = 0;
//
//        final CountDownLatch countDownLatch = new CountDownLatch(1);
//        Future<Integer> result = null;
//        for (int i = 0; i <= 2; i++) {
//            result = threadPoolExecutor.submit(new Callable<Integer>() {
//                @Override
//                public Integer call() throws Exception {
//                    a = 1;
//                    countDownLatch.countDown();
//                    return a;
//                }
//            });
//
//        }
//        Integer fastValue = 0;
//        try {
//            countDownLatch.await();
//            fastValue = result.get();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        return fastValue;
//    }

}
