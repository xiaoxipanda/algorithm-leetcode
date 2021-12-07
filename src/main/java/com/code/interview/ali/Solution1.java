package com.code.interview.ali;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 问题1：不使用字符串到数字转换的库函数，从给定的多个字符串中，
 * 找到第二大的合法数字(不考虑科学计数法) 。
 * 例如输入“12a", "bc", "123", "-12", "0", "a5", 那么输出"0"。
 *
 * @author markingWang
 * @date 2021/11/10 7:33 下午
 */
public class Solution1 {

    /**
     * 不使用字符串到数字转换的库函数，从给定的多个字符串中，
     * 找到第二大的合法数字(不考虑科学计数法)
     *
     * @param strS 字符数组
     * @return 第二大数字
     */
    public static Integer getSecondMaxNum(String[] strS) {
        if (strS.length < 1) {
            return -1;
        }
        List<Integer> numStrList = new ArrayList<>();
        for (String str : strS) {
            if (isNumber(str)) {
                numStrList.add(getNumber(str));
            }
        }
        if (numStrList.size() < 1) {
            return -1;
        }
        if (numStrList.size() == 1) {
            return numStrList.get(0);
        }
        Collections.sort(numStrList);
        return numStrList.get(1);
    }

    /**
     * 将字符串转化为数字
     *
     * @param number 字符串
     * @return int
     */
    public static int getNumber(String number) {
        int resultNum = 0;
        char firstChar = number.charAt(0);
        number = firstChar == '-' ? number.substring(1) : number;
        for (int i = 0; i < number.length(); i++) {
            resultNum = resultNum * 10 + number.charAt(i) - '0';
        }
        return firstChar == '-' ? -resultNum : resultNum;
    }

    /**
     * 判断给定字符串是否为数字
     *
     * @param str str
     * @return boolean
     */
    public static boolean isNumber(String str) {
        str = str.charAt(0) == '-' ? str.substring(1) : str;
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] array = new String[]{"12a", "bc", "123", "-12", "0", "a5"};
        System.out.println(getSecondMaxNum(array));
    }
}
