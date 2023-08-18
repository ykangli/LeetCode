package September2022.day02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/1 21:21
 * Leetcode 77. 组合
 */
public class Combine {
    public static void main(String[] args) {
        

    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(n, result, path, k, 1);
        return result;
    }

    public static void backtrack(int n, List<List<Integer>> result, List<Integer> path, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        //未剪枝
        for (int i = startIndex; i <= n; i++) {
            //剪枝  如果for循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了
            if (path.size() + (n - i + 1) < k) {
                return;
            }
            path.add(i);
            //特别注意是 i + 1  不是 startIndex + 1
            backtrack(n, result, path, k, i + 1);
            //为什么要撤销路径，要保证每一条路径开始的时候都是空的
            path.remove(path.size() - 1);
        }
    }


}
