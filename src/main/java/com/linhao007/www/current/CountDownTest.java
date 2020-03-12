package com.linhao007.www.current;

import java.util.concurrent.*;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/5 18:25
 * @description:
 */
public class CountDownTest {
    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(30, 100, 60,
            TimeUnit.SECONDS, new LinkedBlockingQueue(500));

    class TestCallAble implements Callable<Integer> {

        private Integer number;

        private CountDownLatch countDownLatch;

        public TestCallAble(Integer number, CountDownLatch countDownLatch) {
            this.number = number;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public Integer call() throws Exception {
            countDownLatch.countDown();
            return number;
        }
    }

    public Integer callFast() {
        Integer fastValue = 0;

        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);

            Future<Integer> result = null;
            for (int i = 0; i <= 2; i++) {
                result = threadPoolExecutor.submit(new TestCallAble(i, countDownLatch));
            }

            countDownLatch.await();
            fastValue = result.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fastValue;
    }

}
