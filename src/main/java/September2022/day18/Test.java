package September2022.day18;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/18 19:59
 */
public class Test {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        String[] split = str.split(" ");
        System.out.println(canBeSubstr(split[0], split[1]));
    }

    public static boolean canBeSubstr(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            int val = map1.getOrDefault(ch, 0) + 1;
            map1.put(ch, val);
        }
        for (char ch : s2.toCharArray()) {
            int val = map2.getOrDefault(ch, 0) + 1;
            map2.put(ch, val);
        }
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Integer defaultVal = map2.getOrDefault(entry.getKey(), 0);
            if (entry.getValue() > defaultVal) {
                return false;
            }
        }
        return true;
    }
}
