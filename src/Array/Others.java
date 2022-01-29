package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihui
 */
public class Others {
    /**
     * 54. 螺旋矩阵
     *
     * @param matrix m 行 n 列的矩阵 matrix
     * @return 按照顺时针螺旋顺序 ，返回矩阵中的所有元素
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        // 从外向里一层层的遍历
        // 记录一层中左上角和右下角的坐标
        int[][] coordinate = new int[2][2];
        coordinate[0][0] = 0;
        coordinate[0][1] = 0;
        coordinate[1][0] = row - 1;
        coordinate[1][1] = col - 1;

        while (coordinate[1][0] >= coordinate[0][0] && coordinate[1][1] >= coordinate[0][1]) {
            int i = 0, j = 0;

            // 从左向右移动
            // i 为开始的列数
            i = coordinate[0][1];
            // j 为要到达的列数
            j = coordinate[1][1];
            while (i <= j) {
                result.add(matrix[coordinate[0][0]][i]);
                ++i;
            }

            // 从上向下移动
            // i 为开始的行数，在上一个移动中已经添加末尾的元素
            i = coordinate[0][0] + 1;
            // j 为要到达的行数
            j = coordinate[1][0];
            while (i <= j) {
                result.add(matrix[i][coordinate[1][1]]);
                ++i;
            }

            // 从右向左移动
            // i 为开始的列数，在上一个移动中已经添加末尾的元素
            i = coordinate[1][1] - 1;
            // j 为要到达的列数
            j = coordinate[0][1];
            while (i >= j) {
                result.add(matrix[coordinate[1][0]][i]);
                --i;
            }

            // 从下向上移动
            // i 为开始的行数，在上一个移动中已经添加末尾的元素
            i = coordinate[1][0] - 1;
            // j 为要到达的行数，开始元素已经添加
            j = coordinate[0][0] + 1;
            while (i >= j) {
                result.add(matrix[i][coordinate[0][1]]);
                --i;
            }

            // 修改坐标
            ++coordinate[0][0];
            ++coordinate[0][1];
            --coordinate[1][0];
            --coordinate[1][1];
        }
        // 当只剩一行或一列元素时，应该只在一个方向添加元素，但上边的方法会在逆方向也添加一次
        return result.subList(0, row * col);
    }

    /**
     * 59. 螺旋矩阵 II
     *
     * @param n 正整数
     * @return 生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix
     */
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        // 从外向里一层层的遍历
        // 记录一层中左上角和右下角的坐标
        int left = 0;
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;

        int number = 0;

        while (right >= left && bottom >= top) {
            int i = 0, j = 0;

            // 从左向右移动
            // i 为开始的列数
            i = left;
            // j 为要到达的列数
            j = right;
            while (i <= j) {
                result[top][i] = ++number;
                ++i;
            }

            // 从上向下移动
            // i 为开始的行数，在上一个移动中已经添加末尾的元素
            i = top + 1;
            // j 为要到达的行数
            j = bottom;
            while (i <= j) {
                result[i][right] = ++number;
                ++i;
            }

            // 从右向左移动
            // i 为开始的列数，在上一个移动中已经添加末尾的元素
            i = right - 1;
            // j 为要到达的列数
            j = left;
            while (i >= j) {
                result[bottom][i] = ++number;
                --i;
            }

            // 从下向上移动
            // i 为开始的行数，在上一个移动中已经添加末尾的元素
            i = bottom - 1;
            // j 为要到达的行数，开始元素已经添加
            j = top + 1;
            while (i >= j) {
                result[i][left] = ++number;
                --i;
            }

            // 修改坐标
            ++top;
            ++left;
            --right;
            --bottom;
        }

        return result;
    }
}
