package September2022.day01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/1 10:29
 * Leetcode 46. 全排列
 */
public class Permute {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1};
        List<List<Integer>> permute = permute(arr);
    }

    public static List<List<Integer>> permute(int[] nums) {
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
        //返回条件
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        //所有的选择
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
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
