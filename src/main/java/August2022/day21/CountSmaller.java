package August2022.day21;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/21 16:11
 * 相对于计算总的逆序对，这道题难点在于虽然合并数组时能计算出逆序对数量，但需把当前这个算出的逆序对数量放在原始数组对应的位置上
 *
 *
 *
 *
 * 参考视频：https://www.bilibili.com/video/BV1kR4y1G7d8/?spm_id_from=333.788&vd_source=1864d1a67c3ac368d506e894c786b921
 */
public class CountSmaller {
    public static void main(String[] args) {

    }

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        if (nums.length < 2) {
            resultList.add(0);
            return resultList;
        }
        int[] temp = new int[nums.length];
        mergesort(nums, 0, nums.length - 1, temp, resultList);
        return resultList;
    }

    public static void mergesort(int[] nums, int left, int right, int[] temp, List<Integer> resultList) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergesort(nums, left, mid, temp, resultList);
        mergesort(nums, mid + 1, right, temp, resultList);
        mergeTwoSortedArr(nums, left, mid, right, temp, resultList);
    }

    public static void mergeTwoSortedArr(int[] nums, int left, int mid, int right, int[] temp, List<Integer> resultList) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                nums[k] = temp[j];
                j++;
            } else if (j > right) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] < temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                int pairs = mid - i + 1;
                //i的位置
                resultList.add(pairs);
                j++;
            }
        }
    }

}
