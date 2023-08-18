package August2022.day23;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/23 21:38
 * 20. 有效的括号
 * 右括号需要与最近的左括号匹配    遇到左括号入栈，遇到右括号将栈顶左括号取出对比
 */
public class IsValid {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    Character pop = stack.pop();
                    if (pop == null || !map.get(c).equals(pop)) {
                        return false;
                    }
                }

            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
