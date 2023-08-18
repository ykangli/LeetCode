package September2022.day08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/8 16:44
 * Leetcode 131. 分割回文串
 */
public class Partition {
    private List<List<String>> result = new ArrayList<>();
    private List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
//        String[] arr = new String[s.length()];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = String.valueOf(s.charAt(i));
//        }
        backtrack(s, 0);
        return result;
    }

    public void backtrack(String arr, int start) {
        

    }


    //判断回文串
    public boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }


}
