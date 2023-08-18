package May2022;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/7/6 19:09
 */
public class DomainExtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        int num1 = Integer.parseInt(num);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < num1; i++) {
            String s = scanner.nextLine().toLowerCase();
            stringBuilder.append(s);
        }
        String input = stringBuilder.toString();
        HashSet<String> result = extractDomain(input);
        for (String domain : result) {
            System.out.println(domain);
        }

    }

    public static HashSet<String> extractDomain(String s) {
        HashSet<String> result = new HashSet<>();
        String pattern = "(http|https)://(www.)?(\\w+(\\.)?)+";
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(s);
        while (matcher.find()) {
            result.add(matcher.group());

        }
        if (result.size() == 0) {
            result.add("None");
        }
        return result;
    }

}
