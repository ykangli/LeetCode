package August2022.day01;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/13 15:43
 * 最长回文字串  leetcode  5
 * 中心扩散法，两种情况， 中心为一个字符，中心为两个字符
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = longestPalindrome("babad");
        System.out.println(s);
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1 ) {
            return s;
        }
        String longestStr = "";
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            //中心为单字符
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;
                if (len > longest) {
                    longest = len;
                    longestStr = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i + 1;
            //中心为双字符
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;
                if (len > longest) {
                    longest = len;
                    longestStr = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return longestStr;
    }
}
