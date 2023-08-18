package September2022.day23;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/11/2 14:05
 */
public class Dp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int value = value(arr);
        System.out.println(value);
    }

    public static int value(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    arr[i][j] += arr[i][j - 1];
                } else if (j == 0) {
                    arr[i][j] += arr[i - 1][j];
                } else  {
                    arr[i][j] += Math.max(arr[i][j - 1], arr[i - 1][j]);
                }
            }
        }
        return arr[arr.length - 1][arr.length - 1];
    }


}
