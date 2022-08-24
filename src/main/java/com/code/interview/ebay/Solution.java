package com.code.interview.ebay;

public class Solution {

    public static int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int pre = 0;
        int ans = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            ans = Math.max(ans, pre);
        }
        return ans;
    }

    public static int fib(int n){
        if (n == 1 || n == 0){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
//        System.out.println("test01=" + maxSubArray(new int[]{}));
//        System.out.println("test02=" + maxSubArray(new int[]{1}));
//        System.out.println("test03=" + maxSubArray(new int[]{1, -1}));
//        System.out.println("test04=" + maxSubArray(new int[]{-1, -2, 3, 2, 5, -1}));
//        System.out.println("test05=" + maxSubArray(new int[]{-1, -1, 1, 1, -1, -1, -1, -1, 1, 1}));


        System.out.println("test01=" + fib(1));
        System.out.println("test02=" + fib(2));
        System.out.println("test03=" + fib(3));
        System.out.println("test04=" + fib(4));
        System.out.println("test05=" + fib(5));
        System.out.println("test06=" + fib(28));
        System.out.println("test07=" + fib(29));
        System.out.println("test08=" + fib(30));
    }
}
