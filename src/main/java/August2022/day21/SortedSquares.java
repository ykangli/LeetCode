package August2022.day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/21 18:00
 * leetcode 977. 有序数组的平方
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 * 思路： 数组平方后的最大值一定在最左边或者最右边  ===> 双指针
 */
public class SortedSquares {
    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        int[] ints = sortedSquares(nums);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] sortedSquares(int[] nums) {
        List<Integer> result = new ArrayList<>(nums.length);
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            if (left > right) {
                break;
            }
            if (nums[left] * nums[left] <= nums[right] * nums[right]) {
                result.add(nums[left] * nums[left]);
                left++;
            } else {
                result.add(nums[right] * nums[right]);
                right--;
            }
        }
        int[] resultArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            resultArr[i] = result.get(i);
        }
        Arrays.sort(resultArr);
        return resultArr;
    }

    public int[] sortedSquaresQuick(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int k = nums.length - 1;
        int[] res = new int[nums.length];
        while (i <= j) {
            if(nums[i] * nums[i] > nums[j] * nums[j]) {
                res[k] = nums[i] * nums[i];
                i++;
                k--;
            } else {
                res[k] = nums[j] * nums[j];
                j--;
                k--;
            }
        }
        return res;
    }
}
