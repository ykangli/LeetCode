package September2022.day18;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/18 20:29
 */
public class Find {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String string = cin.next();
        String[] strArr = string.split(",");
        int[] arr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        System.out.println(findLostNum(arr));
    }

    public static int findLostNum(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int i : array) {
            set.add(i);
        }
        for (int i = 0; i < set.size(); i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return set.size();
    }
}
