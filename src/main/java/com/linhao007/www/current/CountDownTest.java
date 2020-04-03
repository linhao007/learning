package com.linhao007.www.current;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/5 18:25
 * @description:
 */
public class CountDownTest {

    /**
     * 参数初始化
     */
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    /**
     * 核心线程数量大小
     */
    private static final int corePoolSize = Math.max(2, Math.min(CPU_COUNT - 1, 4));

    /**
     * 线程池最大容纳线程数
     */
    private static final int maximumPoolSize = CPU_COUNT * 2 + 1;

    /**
     * 线程池最大容纳线程数
     */
    private static final int keepAliveTime = 30;


    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
            TimeUnit.SECONDS, new LinkedBlockingQueue(500), new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "countDownLunch #" + mCount.getAndIncrement());
        }
    });

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

    public static void main(String[] args) {
        System.out.println(CPU_COUNT + ":" + corePoolSize);
    }

}
