package August2022.day22;

import java.util.PriorityQueue;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/22 10:55
 * 42. 接雨水     单调栈不好理解    最好理解的应该就是利用动态规划
 * 当前位置雨水量  trap = min（左边柱子最大值，右边柱子最大值）- 当前位置高度
 * 可用两层动态规划，求出当前位置左边柱子的最大值和当前位置右边柱子的最大值
 * maxLeft[i] 定义为 当前位置左边柱子的最大值
 * maxRight[i] 定义为 当前位置右边柱子的最大值
 * 参考链接：https://www.programmercarl.com/0042.%E6%8E%A5%E9%9B%A8%E6%B0%B4.html#%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E8%A7%A3%E6%B3%95
 */
public class Trap {
    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap(height);
        System.out.println(trap);


    }

    public static int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        //maxLeft[i] 为当前位置左边最高的柱子
        maxLeft[0] = height[0];
        for (int i = 1; i < maxLeft.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }

        //maxRight[i] 为当前位置右边最高的柱子
        maxRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }

        int count = 0;
        for (int i = 0; i < height.length; i++) {
            int trap = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (trap > 0) {
                count += trap;
            }
        }
        return count;
    }

}
