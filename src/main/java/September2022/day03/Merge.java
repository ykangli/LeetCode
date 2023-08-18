package September2022.day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/1 18:30
 * Leetcode 56. 合并区间
 */
public class Merge {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        merge(arr);
    }

    public static int[][] merge(int[][] intervals) {
        //按照区间开始从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[][] result = new int[intervals.length][2];
        int index = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (index == -1 || (intervals[i][0] > intervals[i - 1][1])) {
                index++;
                result[index] = intervals[i];
            } else {
                result[index][1] = Math.max(intervals[i][1], result[index][1]);
            }
        }
        return Arrays.copyOf(result, index + 1);
    }


}
