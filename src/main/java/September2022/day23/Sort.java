package September2022.day23;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/11/2 14:29
 */
public class Sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        sort(arr);
    }

    public static void  sort(int[] arr) {
        int length = arr.length;
        int minIndex, tempNum;
        for (int i = 0; i < length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            tempNum = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tempNum;
            String s = Arrays.toString(arr);
            String output = s.substring(1, s.length() - 1);
//            System.out.println(output);
            System.out.println("第" + (i + 1) + "趟" + "：" + output + ",");
        }
    }
}
