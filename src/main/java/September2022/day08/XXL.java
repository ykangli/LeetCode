package September2022.day08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/14 20:25
 */
public class XXL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String s = scanner.next();
            list.add(s);
        }
        for (String s : list) {
            xxl(s);
        }
    }

    static public void xxl(String s) {
        int sum = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
                sum++;
            } else {
                stack.push(ch);
            }
        }
        if(sum % 2 == 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
