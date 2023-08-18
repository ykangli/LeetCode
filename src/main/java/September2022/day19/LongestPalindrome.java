package September2022.day19;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/20 16:25
 * 最长回文字串   1.单中心 2.双中心
 */
public class LongestPalindrome {
    public static void main(String[] args) {

    }
    public String longestPalindrome(String s) {
        String longestStr = "";
        int longestLen = 0;

        //单中心
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;
                if (len > longestLen) {
                    longestLen = len;
                    longestStr = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        //双中心
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;
                if (len > longestLen) {
                    longestLen = len;
                    longestStr = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return longestStr;
    }



}
