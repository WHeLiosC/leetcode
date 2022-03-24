package DynamicProgramming;

/**
 * @author lihui
 */
public class UniquePaths {
    /**
     * 62. 不同路径 (动态规划)
     *
     * @param m 行数
     * @param n 列数
     * @return 一个机器人位于一个 m x n 网格的左上角，每次只能向下或者向右移动一步。
     * 机器人试图达到网格的右下角，总共有多少条不同的路径
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 62. 不同路径 (组合数)
     *
     * @param m 行数
     * @param n 列数
     * @return 一个机器人位于一个 m x n 网格的左上角，每次只能向下或者向右移动一步。
     * 机器人试图达到网格的右下角，总共有多少条不同的路径
     */
    public int uniquePathsMath(int m, int n) {
        // 从左上角到右下角一共需要走 m+n-2 步，需要向下走 m-1 步，向右走 n-1 步
        long ans = 1;
        for (int i = 1, j = n; i <= m - 1; i++, j++) {
            // 组合数计算公式
            ans = ans * j / i;
        }
        return (int) ans;
    }

    /**
     * 63. 不同路径 II
     *
     * @param obstacleGrid 网格中的障碍物和空位置分别用 1 和 0 来表示
     * @return 从左上角到右下角将会有多少条不同的路径
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < col && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        UniquePaths u = new UniquePaths();
        int[][] test = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int a = u.uniquePathsWithObstacles(test);
    }
}
