package August2022.day29;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/29 9:44
 * LEETCODE 54. 螺旋矩阵    置四个边界，模拟从左到右，从上到下，从右到左，从下到上
 */
public class SpiralOrder {
    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n = matrix.length * matrix[0].length;
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (n > 0) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
                n--;
                if (n <= 0) {
                    return result;
                }
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
                n--;
                if (n <= 0) {
                    return result;
                }
            }
            right--;
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
                n--;
                if (n <= 0) {
                    return result;
                }
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
                n--;
                if (n <= 0) {
                    return result;
                }
            }
            left++;
        }
        return result;

    }


}
