package August2022.day21;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/21 11:44
 * <p>
 * 剑指 Offer 51. 数组中的逆序对
 * <p>
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 * <p>
 * !!!! 合并阶段 本质上是 合并两个排序数组 的过程，而每当遇到 左子数组当前元素 > 右子数组当前元素 时，
 * 意味着 「左子数组当前元素 至 末尾元素」 与 「右子数组当前元素」 构成了若干 「逆序对」 。
 * 此时有mid - i + 1 个逆序对
 */
public class ReversePairs {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 5, 6, 4};
        int i = reversePairs(nums);
        System.out.println(i);
    }

    public static int reversePairs(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int[] temp = new int[nums.length];
        return mergerSort(nums, 0, nums.length - 1, temp);
    }

    public static int mergerSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        //左边区间中的逆序对
        int leftPairs = mergerSort(nums, left, mid, temp);
        //右边区间中的逆序对
        int rightPairs = mergerSort(nums, mid + 1, right, temp);
        //当右边区间的第一个大于等于左边区间的最后一个时候，表示nums已经有序，不需要再合并。 也就没有跨越两个区间的逆序对了
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }
        //跨越两个区间的逆序对
        int crossPairs = mergerTwoSortedArray(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    public static int mergerTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right ; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                nums[k] = temp[j];
                j++;
            } else if (j > right) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += mid - i + 1;
            }
        }
        return count;
    }


}



