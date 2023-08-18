package August2022.day16;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/16 20:25
 * 无重复字符的最长字串   滑动窗口
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "tmmzuxt";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);

    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int lengthOfSubstring = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.get(c) > 1) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            lengthOfSubstring = Math.max(right - left + 1, lengthOfSubstring);

        }
        return lengthOfSubstring;
    }
}
