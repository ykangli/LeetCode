package May2022.day01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/5/6 15:50
 */
public class ValidAnagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        char[] arrayS = s.toCharArray();
        char[] arrayT = t.toCharArray();
        Arrays.sort(arrayS);
        Arrays.sort(arrayT);
        String s1 = String.valueOf(arrayS);
        String s2 = String.valueOf(arrayT);
        return  s1.equals(s2);
    }
}
