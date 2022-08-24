package Rectangle;

/**
 * @author lihui
 */
public class MaximalRectangle {
    /**
     * 85. 最大矩形
     *
     * @param matrix 仅包含 0 和 1 的二进制矩阵
     * @return 找出只包含 1 的最大矩形，并返回其面积
     */
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        // left 矩阵存储一个元素的左边有多少个连续的 1
        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int width = left[i][j];
                int area = width;
                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(width, left[k][j]);
                    area = Math.max(area, width * (i - k + 1));
                }
                res = Math.max(res, area);
            }
        }

        return res;
    }
}
