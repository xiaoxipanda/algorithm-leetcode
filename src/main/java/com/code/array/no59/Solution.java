package com.code.array.no59;

/**
 * 螺旋矩阵 II
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 *
 * @author markingWang
 * @date 2022/2/16 4:36 下午
 */
public class Solution {

    public int[][] generateMatrix(int n) {
        // 列
        int l = 0, r = n - 1;
        // 行
        int t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = l; i <= r; i++) {
                // left to right.
                mat[t][i] = num++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                // top to bottom.
                mat[i][r] = num++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                // right to left.
                mat[b][i] = num++;
            }
            b--;
            for (int i = b; i >= t; i--) {
                // bottom to top.
                mat[i][l] = num++;
            }
            l++;
        }
        return mat;
    }
}
