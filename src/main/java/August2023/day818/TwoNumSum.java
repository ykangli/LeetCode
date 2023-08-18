package August2023.day818;

import java.util.HashMap;
import java.util.LinkedHashMap;

/* 1. 两数之和
    * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target
    * 的那 两个 整数，并返回它们的数组下标。
    * 你可以假设每种输入只会对应一个答案。
    * 但是，数组中同一个元素不能使用两遍。
    * 你可以按任意顺序返回答案。
    * 示例 1：
    * 输入：nums = [2,7,11,15], target = 9
    * 输出：[0,1]
    * 解释：因为 nums[0] + nums[1] == 9 ，返回[0, 1] 。
    * 示例 2：
    * 输入：nums = [3,2,4], target = 6
    * 输出：[1,2]
    * 示例 3：
    * 输入：nums = [3,3], target = 6
    * 输出：[0,1]
    * 提示：
    * 2 <= nums.length <= 10^3
    * -10^9 <= nums[i] <= 10^9
    * -109 <= target <= 109
    * 只会存在一个有效答案
    * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
    * Related Topics 数组 哈希表
    */


/**
 * @author ykangli
 * @version 1.0
 * @date 2023/8/18 10:47
 */
public class TwoNumSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        //用hash表来存target - num[i]的位置
        for (int i = 0; i < nums.length; i++) {
            //看当前target - num[i]在hash表中是否存在
            Integer minusPos = map.get(target - nums[i]);
            //如果存在，说明找到了,返回
            if (minusPos != null) {
                res[0] = minusPos;
                res[1] = i;
                return res;
            } else {//如果不存在，将当前num[i]的位置存入hash表
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
