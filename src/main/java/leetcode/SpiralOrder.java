package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * https://leetcode.cn/problems/spiral-matrix/solution/luo-xuan-ju-zhen-by-liao-tian-yi-jian/
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        int m = matrix.length; // 行
        int n = matrix[0].length; // 列
        int i = 0; // 层数
        int count = (Math.min(m, n) + 1) / 2; // 统计从外向内的总层数，至少为一层
        while (i < count) {
            // 从左到右：行不变，列逐渐增大；j为变化的列
            for (int j = i; j < n - i; j++) {
                list.add(matrix[i][j]);
            }
            // 从上倒下：列不变，行逐渐增大，j为变化的行
            for (int j = i + 1; j < m - i; j++) {
                list.add(matrix[j][(n - 1) - i]);
            }
            // 从右往左：行不变，列逐渐减小，j为变化的列
            // (n-1)-(i+1) 这里的i+1是为了去除最右下角的那个数
            // 这里的m-1-i != i是用来保证属于同一层的
            for (int j = (n - 1) - (i + 1); j >= i && (m - 1 - i != i); j--) {
                list.add(matrix[((m - 1) - i)][j]);
            }
            // 从下到上：列不变，行逐渐减少，j为可变的行
            // (m-1)-(i+1) 是为了去除最左上角的数；j >= i+1，是为了保证当前行为第二行
            // (n-1-i) != i 是用来保证属于同一层的
            for (int j = (m - 1) - (i + 1); j >= i + 1 && (n - 1 - i) != i; j--) {
                list.add(matrix[j][i]);
            }
            i++; // 层数加1，继续向内层递进
        }
        return list;
    }
}
