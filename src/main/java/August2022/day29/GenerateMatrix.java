package August2022.day29;

import java.util.Arrays;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/29 9:56
 * Leetcode 59. 螺旋矩阵 II  设置四个边界，模拟从左到右，从上到下，从右到左，从下到上
 */
public class GenerateMatrix {
    public static void main(String[] args) {
        int[][] ints = generateMatrix(3);
        System.out.println(Arrays.deepToString(ints));
    }


    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int init = 1;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        while (init <= n * n) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = init;
                init++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = init;
                init++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = init;
                init++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = init;
                init++;
            }
            left++;
        }
        return matrix;
    }

}
