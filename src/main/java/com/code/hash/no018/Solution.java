package com.code.hash.no018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
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
        // 排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
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
