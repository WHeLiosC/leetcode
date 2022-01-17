package Array;

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
        int arrowNum = row * col - 1;
        int rowArrow = row - 1;
        int colArrow = col - 1;
        for (int i = 0; i < arrowNum; i++) {
            // 横向移动

        }
    }
}
