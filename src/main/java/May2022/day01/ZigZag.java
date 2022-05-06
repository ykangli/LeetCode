package May2022.day01;

import java.util.Scanner;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/5/6 15:46
 */
public class ZigZag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int numRows = scanner.nextInt();
        String convert = convert(s, numRows);
        System.out.println(convert);
    }

    public static String convert(String s, int numRows) {
        boolean flag = true;
        String[] rows = new String[numRows];
        int index = 0;
        for (char c : s.toCharArray()) {
            if (rows[index] == null || rows[index].length() == 0) {
                rows[index] = String.valueOf(c);
            } else {
                rows[index] = rows[index] + c;
            }
            if (rows.length == 1) {

            } else if (flag) {
                index++;
            } else {
                index--;
            }
            if (index == rows.length - 1) {
                flag = false;
            }
            if (index == 0) {
                flag = true;
            }
        }
        StringBuilder result = new StringBuilder();
        for (String row : rows) {
            if (row == null) {
                break;
            }
            result.append(row);
        }
        return result.toString();
    }
}
