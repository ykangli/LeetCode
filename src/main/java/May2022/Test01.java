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
 * @date 2022/7/6 20:29
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
//        System.out.println(n);
        List<String> strs = new ArrayList<>();
        for(int i = 0; i < n;i++){
            strs.add(scanner.nextLine().toLowerCase());
        }
        HashSet<String> set = new HashSet<>();
        for(String s:strs){
            String[] https = s.split(" ");
            for(String http:https){
                if(http.length() < 14){
                    continue;
                }
                // 按指定模式在字符串查找
                String pattern = "(http|https)://(www.)?(\\w+(\\.)?)+";
                String result = "";
                // 创建 Pattern 对象
                Pattern r = Pattern.compile(pattern);
                // 现在创建 matcher 对象
                Matcher m = r.matcher(http);
                if (m.find()) {
                    result=m.group();
                    set.add(result);
                }
            }
        }
        if (set.size() == 0) {
            System.out.println("none");
        }else{
            for(String s:set){
                System.out.println(s);
            }
        }
    }
}
