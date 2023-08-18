package May2022.day04;

import java.util.Arrays;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/5/17 16:05
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }

    public static void rotate(int[][] matrix) {
        //先转置
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                if (i == j) {
                    continue;
                } else {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        //以垂直轴镜像对称
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == matrix[0].length / 2) {
                    break;
                }
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - j - 1];
                matrix[i][matrix[0].length - j - 1] = temp;
            }
        }
    }
}
