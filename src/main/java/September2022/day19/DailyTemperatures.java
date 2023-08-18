package September2022.day19;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/20 11:35
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty() || temperatures[i] < temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    Integer index = stack.pop();
                    res[index] = i - index;
                }
                stack.push(i);
            }
        }
        return res;
    }
}
