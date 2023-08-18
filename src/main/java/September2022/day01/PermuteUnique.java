package September2022.day01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/1 11:16
 * Leetcode 47. 全排列 II
 */
public class PermuteUnique {
    public static void main(String[] args) {

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        //最后的所有全排列结果
        List<List<Integer>> result = new ArrayList<>();
        //叶子结点，一次的全排列结果
        List<Integer> path = new ArrayList<>();
        //标记是否使用
        int[] used = new int[nums.length];
        dfs(nums, path, used, result);
        return result;
    }

    public static void dfs(int[] nums, List<Integer> path, int[] used, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        //nums中的数字在同一层使用过就不能再使用了，利用map
        //区分剩下的used是做选择用，用在下一层     map是用在同一层
        Map<Integer, Integer> map = new HashMap<>();
        //所有的选择
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1 || (map.get(nums[i]) != null && map.get(nums[i]) == 1)) {
                continue;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            //做选择
            path.add(nums[i]);
            used[i] = 1;
            //剩下的继续递归选择
            dfs(nums, path, used, result);
            //撤销选择
            path.remove(path.size() - 1);
            used[i] = 0;
        }

    }


}
