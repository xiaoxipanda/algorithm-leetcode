package com.code.interview.bytedance;

/**
 * 带精度的平方根
 */
public class Solution {


    public static int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static double mySqrt01(int num, double precision) {
        double tmp, left = 0, right = num, middle = left + (right - left) / 2;
        while (Math.abs(tmp = (middle * middle - num)) > precision) {
            if (tmp > 0){
                right = left + (right - left) / 2;
            }else {
                left =  left + (right - left) / 2;
            }
            middle =  left + (right - left) / 2;
        }
        return middle;
    }

    public static double mySqrt02(int value, double e) {
        double right = value, left = 1;
        while (right - left > e) {
            right = (right + left) / 2;
            left = value / right;
        }
        return right;
    }

    public static void main(String[] args) {
        double v = mySqrt01(10, 0.000001);
        System.out.println(v);
        System.out.println(Math.sqrt(10));
    }

}
