package August2022.day16;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/17 10:26
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 二分查找，找target后继续用二分查找看左边有没有和它一样的，看右边有没有和它一样的
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {2, 2};
        int target = 3;
        int[] ints = searchRange(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[]{leftIndex(nums, target), rightIndex(nums, target)};
    }

    public static int leftIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                //找到了，左边再没有相同的了，直接返回
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                } else { //找到了，左边还有相同的
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int rightIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                //找到了，右边再没有相同的了，直接返回
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    return mid;
                } else {//找到了，右边有相同的了
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
