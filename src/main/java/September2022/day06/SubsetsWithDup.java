package September2022.day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/6 10:02
 * Leetcode 90. 子集 II
 * 利用
 */
public class SubsetsWithDup {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return result;
    }

    public void backtrack(int[] nums, int start) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            //

            backtrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
