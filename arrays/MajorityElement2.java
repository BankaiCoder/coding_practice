package coding_practice.arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 3 };
        System.out.println(majorityElement(arr));
    }

    public static List<Integer> majorityElement(int[] arr) {
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }

        int can1 = 0, can2 = 1, count1 = 0, count2 = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == can1) {
                count1++;
            } else if (arr[i] == can2) {
                count2++;
            } else if (count1 == 0) {
                can1 = arr[i];
                count1 = 1;
            } else if (count2 == 0) {
                can2 = arr[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int i : arr) {
            if (i == can1) {
                count1++;
            } else if (i == can2) {
                count2++;
            }
        }

        if (count1 > n / 3) {
            result.add(can1);
        } else {
            result.add(can2);
        }

        return result;
    }
}
