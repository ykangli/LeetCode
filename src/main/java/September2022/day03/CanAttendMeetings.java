package September2022.day03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/4 11:28
 * Leetcode 252. 会议室
 * 因为一个人在同一时刻只能参加一个会议，因此题目实质是判断是否存在重叠区间，这个简单，
 * 将区间按照会议开始时间进行排序，然后遍历一遍判断即可。
 */
public class CanAttendMeetings {
    public static void main(String[] args) {

    }

    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1) {
            return true;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }

}
