package PreSum;

/**
 * 304. 二维区域和检索 - 矩阵不可变 (10-9-21)
 *
 * @author lihui
 */
class NumMatrix304 {
    private final int[][] preSum;

    public NumMatrix304(int[][] matrix) {
        // row
        int r = matrix.length;
        // column
        int c = matrix[0].length;

        preSum = new int[r + 1][c + 1];
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
    }

    public static void main(String[] args) {
        int[][] m = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix304 nm = new NumMatrix304(m);
        int res = nm.sumRegion(2, 1, 4, 3);
        System.out.println(res);
    }

    // 二维矩阵前缀和
}

