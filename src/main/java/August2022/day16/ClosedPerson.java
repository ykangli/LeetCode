package August2022.day16;

import java.util.*;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/17 19:42
 */
public class ClosedPerson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String positiveStr = scanner.nextLine();
        String[] positive = positiveStr.split(" ");
        int m = scanner.nextInt();
        System.out.println(m);
        int n = scanner.nextInt();
        String[][] person = new String[m][n];
        for (int i = 0; i < m; i++) {
            String s = scanner.nextLine();
            String[] row = s.split(" ");
            person[i] = row;
        }
        List<Set<String>> list = new ArrayList<>();
        for (int i = 0; i < positive.length; i++) {
            Set<String> closed = closed(m, n, person, positive[i]);
            if (closed.size() != 0) {
                list.add(closed);
            }
        }

        if (list.size() == 0) {
            System.out.println("[]");
        } else {
            Set<String> resultSet = list.get(0);
            list.forEach(item -> {
                resultSet.retainAll(item);
            });
            System.out.println(resultSet.toString());
        }

    }

    public static Set<String> closed(int m, int n, String[][] person, String target) {
        Set<String> set = new HashSet<>();
        int targetI = -1;
        int targetJ = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (Objects.equals(person[i][j], target)) {
                    targetI = i;
                    targetJ = j;
                }
            }
        }
        for (int i = targetI - 2; i < targetI + 3; i++) {
            for (int j = targetJ - 2; j < targetJ + 3; j++) {
                if (i >= 0 && i <= n -1 && j >= 0 && j<= m-1 && person[i][j] != target) {
                    set.add(person[i][j]);
                }
            }
        }
        return set;
    }


}
