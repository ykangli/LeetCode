package May2022.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/5/7 9:48
 */
public class Permutations {
    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList<>();
        int[] used = new int[nums.length];
        backtrack(nums, path, used);
        return result;
    }

    private static void backtrack(int[] nums, List<Integer> path, int[] used) {
        if (path.size() == nums.length) {
            //将一个完整的路径添加到结果集中  注意添加方式 new LinkedList<>(track)
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            //做选择
            path.add(nums[i]);
            used[i] = 1;
            //递归到下一层
            //nums和used的作用就是 [选择列表]， track是[路径]
            backtrack(nums, path, used);
            //撤销选择
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }
}
