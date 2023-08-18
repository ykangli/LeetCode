package August2022.day26;

import java.util.Random;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/26 17:47
 */
public class QuickSort {
    public static void main(String[] args) {

    }

    public static void quicksort(int[] num, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(num, left, right);

        quicksort(num, left, pivot - 1);
        quicksort(num, pivot + 1, right);
    }

    public static int partition(int[] num, int left, int right) {
        Random random = new Random(System.currentTimeMillis());
        int randomPivot = left + random.nextInt(right - left + 1);
        swap(num, left, randomPivot);

        int pivot = num[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (num[i] <= pivot) {
                j++;
                swap(num, i, j);
            }
        }
        swap(num, j, left);
        return j;
    }

    public static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
