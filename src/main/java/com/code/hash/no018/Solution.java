package com.code.hash.no018;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * 四数之和
 * https://leetcode-cn.com/problems/4sum/
 *
 * @author markingWang
 * @date 2022/4/2 10:23 上午
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        return null;
    }

    static ExecutorService executorService = new ThreadPoolExecutor(4, 16, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<String> result2 = new CompletableFuture<>();
//        System.out.println("2 before:" + Thread.currentThread().getName());
//        result2.thenCompose(s -> {
//            System.out.println("2 thenCompose:" + Thread.currentThread().getName());
//            System.out.println("2 thenCompose: " + s);
//            return CompletableFuture.completedFuture(s);
//        });
//        System.out.println("2 after:" + Thread.currentThread().getName());
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                result2.complete("world");
//            }
//        });
//        System.out.println("2 complete:" + Thread.currentThread().getName());



        CompletableFuture<String> result3 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("3 get: " + Thread.currentThread().getName());
                return "Hello world!!!!!!!!!!";
            }
        }, executorService).thenCompose(s -> {
            System.out.println("3 thenCompose:" + Thread.currentThread().getName());
            System.out.println("3 thenCompose: " + s);
            return CompletableFuture.completedFuture(s);
        }).thenApply(s -> {
            System.out.println("3 apply:" + Thread.currentThread().getName());
            System.out.println("3 apply: " + s);
            return s;
        });


//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                result3.complete("world");
//            }
//        });
//        System.out.println("3 before:" + Thread.currentThread().getName());
//        System.out.println("3 after:" + Thread.currentThread().getName());
//        System.out.println("3 complete:" + Thread.currentThread().getName());
    }
}
