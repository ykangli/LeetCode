package July2022.day29;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/7/29 16:16    回溯
 */
public class Permutations {

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        List<List<Integer>> result = permute(input);
        for (Object o : result.toArray()) {
            System.out.println(o.toString());
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        //用来保存所有的路路径
        List<List<Integer>> result = new ArrayList<>();
        //path是一个全局状态量 used是一个全局状态量
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, path, used, result);
        return result;
    }

    public static void dfs(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> result) {
        //base case
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        //for循环是横向
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
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
