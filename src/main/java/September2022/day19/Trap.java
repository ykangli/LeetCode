package September2022.day19;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/20 10:27
 */
public class Trap {
    public int trap(int[] height) {
        int sum = 0;
        // i 位置高度由左右两边最高的决定
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        right[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < left.length; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }
        for (int i = 0; i < height.length; i++) {
            int trap = Math.min(left[i], right[i]) - height[i];
            if (trap > 0) {
                sum += trap;
            }
        }
        return sum;
    }


}
