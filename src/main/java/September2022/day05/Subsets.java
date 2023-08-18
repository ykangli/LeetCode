package September2022.day05;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/5 22:07
 * Leetcode 78. 子集
 */
public class Subsets {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return result;
    }

    public void backtrack(int[] nums, int start) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }


}
