package September2022.day08;

import javafx.scene.transform.Scale;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/14 20:53
 */
public class Exchange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String s = scanner.next();
        String[] split = s.split(",");
        int[] nums = new int[num];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int[] res = exchange(nums);
        System.out.println(Arrays.toString(res));
    }

    static public int[] exchange(int[] nums) {
        int n = nums.length;
        int index = 0;
        int[] res = new int[n];
        for (int num : nums) {
            if (num % 2 == 0) {
                res[index++] = num;
            }
        }
        for (int num : nums) {
            if (num % 2 == 1) {
                res[index++] = num;
            }
        }
        return res;
    }
}
