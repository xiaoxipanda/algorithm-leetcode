package com.code.interview.ali;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Solution {


    static LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>();

    static ExecutorService executorService =  Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        // 生产端
        executorService.submit(Solution::processProducer);
        executorService.submit(Solution::processProducer);
        executorService.submit(Solution::processProducer);

        // 消费端
        executorService.submit(Solution::processConsumer);
        executorService.submit(Solution::processConsumer);

        countDownLatch.await();
    }


    /**
     * consumer 每两秒消费一个数据
     */
    private static void processConsumer() {
        while (true){
            try {
                Thread.sleep(2000);
                System.out.println(take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * producer 每三秒生产一个数据
     */
    private static void processProducer() {
        while (true){
            try {
                Thread.sleep(3000);
                put(new Object());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * add a element
     * @param obj
     * @throws InterruptedException
     */
    public static void put(Object obj) throws InterruptedException {
        queue.put(obj);
    }


    /**
     * take a element
     * @throws InterruptedException
     */
    public static Object take() throws InterruptedException {
        return queue.take();
    }
}
