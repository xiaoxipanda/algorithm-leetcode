package com.code.hash.no202;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 * https://leetcode-cn.com/problems/happy-number/
 *
 * @author markingWang
 * @date 2022/2/25 3:56 下午
 */
public class Solution {

    public boolean isHappy(int n) {
        Set<Integer> happyNumSet = new HashSet<>();

        while (true) {
            int sum = getSum(n);
            if (sum == 1) {
                return true;
            }

            if (happyNumSet.contains(sum)) {
                return false;
            }
            happyNumSet.add(sum);
            n = sum;
        }
    }

    public int getSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
