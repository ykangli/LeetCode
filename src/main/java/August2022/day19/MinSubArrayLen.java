package August2022.day19;

import javax.swing.text.MaskFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/19 10:06
 * 209 长度最小的子数组     滑动窗口，窗口会动态变化，while循环缩小窗口
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        int target = 11;
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int length = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            if (sum >= target) {
                length = right - left + 1;
                minLength = Math.min(length, minLength);
            }
            //窗口是变化的
            while (sum >= target) {
                sum -= nums[left];
                length--;
                if (sum >= target) {
                    minLength = Math.min(length, minLength);
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
