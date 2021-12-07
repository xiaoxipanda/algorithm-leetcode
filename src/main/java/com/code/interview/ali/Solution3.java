package com.code.interview.ali;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 问题3：有3个线程和1个公共的字符数组。线程1的功能就是向数组输出A,线程2的功能就是向数组输出l，线程3的功能就是向数组输出i。
 * 要求按顺序向数组赋值AliAliAli，Ali的个数为n
 *
 * @author markingWang
 * @date 2021/11/10 7:33 下午
 */
public class Solution3 {

    /**
     * 打印次数
     */
    private final int n;

    /**
     * 存入数组的索引
     */
    private volatile int index;

    /**
     * 用于多线程操作锁
     */
    private final Lock lock = new ReentrantLock();

    /**
     * 线程池配置
     */
    private final ExecutorService threadPool = Executors.newFixedThreadPool(3);

    /**
     * 用于等待打印任务结束
     */
    private static CountDownLatch countDownLatch;

    /**
     * 结果列表
     */
    private static String[] resultStrList;

    public Solution3(int n) {
        this.n = n;
        resultStrList = new String[n * 3];
        countDownLatch = new CountDownLatch(n * 3);
    }

    /**
     * 添加数据到数组
     *
     * @param ch  字符
     * @param num 当前的num用于保证顺序
     */
    private void addToArray(String ch, int num) {
        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (index % 3 == num) {
                    resultStrList[index] = ch;
                    index++;
                    i++;
                    System.out.print(ch);
                    countDownLatch.countDown();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * 获取顺序字符串
     *
     * @param n 输出的次数
     * @return 字符数组
     * @throws InterruptedException
     */
    public String[] getStrArr(int n) throws InterruptedException {
        Solution3 solution = new Solution3(n);
        threadPool.execute(() -> solution.addToArray("A", 0));
        threadPool.execute(() -> solution.addToArray("l", 1));
        threadPool.execute(() -> solution.addToArray("i", 2));

        countDownLatch.await();
        return resultStrList;
    }

    public static void main(String[] args) throws InterruptedException {
        Solution3 solution = new Solution3(3);

        solution.threadPool.execute(() -> solution.addToArray("A", 0));
        solution.threadPool.execute(() -> solution.addToArray("l", 1));
        solution.threadPool.execute(() -> solution.addToArray("i", 2));

        countDownLatch.await();

        for (String s : resultStrList) {
            System.out.print(s);
        }
    }
}

