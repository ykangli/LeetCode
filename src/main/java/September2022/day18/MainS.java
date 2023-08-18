package September2022.day18;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/18 20:26
 */
public class MainS {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int num = cin.nextInt();
        System.out.println(revertNum(num));
    }

    public static int revertNum(int number) {
        String s = new StringBuffer(String.valueOf(number)).reverse().toString();
        int res = Integer.parseInt(s);
        return  res;
    }

}
