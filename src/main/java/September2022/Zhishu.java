package September2022;

import java.util.Scanner;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/11/2 14:04
 */
public class Zhishu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int h = scanner.nextInt();
        if (n >= m) {
            System.out.println("error");
            return;
        }

        int sumNum = 0;
        for (int i = n; i <= m ; i++) {
            if (isPrime(i)) {
                sumNum += i;
                if (sumNum > h) {
                    System.out.println(i + "\\" + sumNum);
                }
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n) ; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
