package September2022.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/5 16:49
 * Leetcode 39. 组合总和   未剪枝
 */
public class CombinationSum {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    int sum;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return result;
    }

    public  void backtrack(int[] candidates, int target, int start) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            //通过保证元素之间的相对顺序不变来防止出现重复的子集。  也就是下一层从i开始取，而不是从0开始
            backtrack(candidates, target, i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
