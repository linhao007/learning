package com.linhao007.www.current;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/4/2 10:01
 * @description:
 */
public class ForkJoinTest {

    static class SumTask extends RecursiveTask<Long> {

        static final int THRESHOLD = 100;
        long[] array;
        int start;
        int end;

        public SumTask(long[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }


        @Override
        protected Long compute() {
            //如果任务足够小 则直接计算
            if (end - start <= THRESHOLD) {
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
                return sum;
            }
            // 任务太大,一分为二:
            int middle = (end + start) / 2;
            SumTask subtask1 = new SumTask(this.array, start, middle);
            SumTask subtask2 = new SumTask(this.array, middle, end);
            invokeAll(subtask1, subtask2);
            Long subresult1 = subtask1.join();
            Long subresult2 = subtask2.join();
            Long result = subresult1 + subresult2;
            return result;
        }
    }

    public static void main(String[] args) {
        // 创建随机数组成的数组:
        long[] array = new long[10];
        for (long i = 1; i <= 10; i++) {
            array[(int) (i - 1)] = i;
        }
        // fork/join task:
        // 最大并发数4
        ForkJoinPool fjp = new ForkJoinPool(4);
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        Long result = fjp.invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");

        long startTime_01 = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        long endTime_02 = System.currentTimeMillis();
        System.out.println("foreach sum: " + sum + " in " + (endTime_02 - startTime_01) + " ms.");

        long reduce = LongStream.rangeClosed(0, 400).parallel().reduce(0, (x, y) -> x + y);

    }

}
