package September2022.day08;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/13 16:42
 * 蹦蹦跳游戏
 */
public class Solution {
    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverRange = 0;
        //在覆盖范围内更新最大的覆盖范围
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
