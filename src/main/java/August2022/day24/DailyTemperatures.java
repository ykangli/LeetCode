package August2022.day24;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/24 12:08
 * 利用单调栈  从栈底到栈顶减小
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temp = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dailyTemperatures(temp);
        String s = Arrays.toString(ints);
        System.out.println(s);
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty() || temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    Integer index = stack.pop();
                    result[index] = i - index;
                }
                stack.push(i);
            }
        }
        return result;

    }


}
