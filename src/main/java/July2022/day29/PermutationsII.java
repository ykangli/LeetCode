package July2022.day29;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/7/29 16:39
 */
public class PermutationsII {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> result = permuteUnique(nums);
        for (Object o : result.toArray()) {
            System.out.println(o);
        }

    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        //存储所有的路径
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        //排序
        Arrays.sort(nums);
        // path是一个全局状态量 used是一个全局状态量
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, path, used, result);
        return result;
    }


    public static void dfs(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (nums.length == path.size()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, path, used, result);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

}
