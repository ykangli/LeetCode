package May2022.day03;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/5/8 19:36
 */
public class SortColors {
    public static void main(String[] args) {
        int[] input = {2, 0, 2, 1, 1, 0};
        sortColors3(input);
        System.out.println(Arrays.toString(input));
    }

    public static void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivot = quickPass(nums, low, high);
            quickSort(nums, 0, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }
    }

    public static int quickPass(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] > pivot) {
                high--;
            }
            if (low < high) {
                nums[low] = nums[high];
                low++;
            }
            while (low < high && nums[low] < pivot) {
                low++;
            }
            if (low < high) {
                nums[high] = nums[low];
                high--;
            }
        }
        nums[low] = pivot;
        return low;
    }

    //优化后的
    public static void sortColors2(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            //当nums[i] == 2时，交换过来的可能还是2，所以当前位置要继续佳欢，一直交换到遇到1为止
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p2--;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p0++;
            }
        }
    }

    //计数排序.  0,1,2各有多少个，然后再变量填充
    public static void sortColors3(int[] nums) {
        int num0 = 0;
        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            if (num == 0) {
                num0++;
            } else if (num == 1) {
                num1++;
            } else {
                num2++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (num0 != 0) {
                nums[i] = 0;
                num0--;
            } else if (num1 != 0) {
                nums[i] = 1;
                num1 --;
            } else {
                nums[i] = 2;
            }
        }
    }

}
