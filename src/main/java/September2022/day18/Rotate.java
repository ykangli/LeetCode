package September2022.day18;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/18 10:11
 * Leetcode 48. 旋转图像
 */
public class Rotate {
    public static void main(String[] args) {

    }

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                if(i == j) {
                    continue;
                }else {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        int mid = matrix.length / 2;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j < mid) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][matrix.length - i];
                    matrix[i][matrix.length - i] = temp;
                }
            }
        }
    }


}
