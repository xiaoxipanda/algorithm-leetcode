package com.code.no876;

import com.sun.deploy.util.StringUtils;

/**
 * 两个大字符串整数的减法
 */
public class Main {


    /**
     * 两个大字符串整数的减法
     *
     * @param a 字符串1
     * @param b 字符串2
     * @return 字符串减法之后的string
     */
    public static String minus(String a, String b) {
        // 判断边界条件
        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }

        //1. 将字段串转化为数字
        Integer aNum = Integer.parseInt(a);
        Integer bNum = Integer.parseInt(b);

        //2. 将数字做减法
        Integer resultNum = Math.abs(aNum - bNum);

        //3. 将减法做完的数转化为string
        return String.valueOf(resultNum);
    }


    /**
     * 两个大字符串整数的减法
     *
     * @param a 字符串1
     * @param b 字符串2
     * @return 字符串减法之后的string
     */
    public static String minus1(String a, String b) {
        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int length = Math.max(aChars.length, bChars.length);
        StringBuilder resultTemp = new StringBuilder();
        // 按位减操作
        boolean isDre = false;
        for (int i = length - 1; i >= 0; i--) {
            int aBitNum = 0;
            if (i <= aChars.length - 1) {
                aBitNum = aChars[aChars.length - 1];
            }

            int bBitNum = 0;
            if (i <= bChars.length - 1) {
                bBitNum = bChars[aChars.length - 1];
            }

            int dreNum = aBitNum - bBitNum;
            if (isDre) {
                dreNum = dreNum - 1;
            }
            if (dreNum >= 0) {
                resultTemp.append(aBitNum - bBitNum);
                isDre = false;
            } else {
                resultTemp.append(bBitNum - aBitNum);
                isDre = true;
            }
        }
        StringBuilder result = new StringBuilder();
        char[] resultTempChars = resultTemp.toString().toCharArray();
        for (int i = resultTempChars.length - 1; i >= 0; i--) {
            result.append(resultTempChars[i]);
        }
        return result.toString();
    }

}
