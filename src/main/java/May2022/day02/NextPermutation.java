package May2022.day02;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/5/7 9:12
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] input = {4, 2, 0, 2, 3, 2, 0};
        nextPermutation(input);
        System.out.println(Arrays.toString(input));
    }

    public static void nextPermutation(int[] nums) {
        //value为i，key为前面比自己小的最近位置
        TreeMap<Integer, Integer> map = new TreeMap<>();


        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (map.containsKey(j)) {
                        break;
                    }
                    map.put(j, i);
                    break;
                }
            }
        }
        if (map.size() == 0) {
            Arrays.sort(nums);
            return;
        }
        //利用TreeMap找到最后边出现比自己小的位置，也就是最大的key
        int temp = nums[map.lastKey()];
        nums[map.lastKey()] = nums[map.get(map.lastKey())];
        nums[map.get(map.lastKey())] = temp;
        Arrays.sort(nums, map.lastKey() + 1, nums.length);
    }

}
