package coding_practice.sortingandTwoPointers;

import java.util.HashMap;
import java.util.Map;

public class TwoDifference {
    public static void main(String[] args) {
        int[] arr = { 5, 20, 3, 2, 5, 80 };
        int size = 6;
        int n = 78;

        System.out.println(difference(arr, size, n));
    }

    public static boolean difference(int[] arr, int size, int n) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            if (n == 0 && map.containsKey(arr[i])) {
                return true;
            }
            map.put(arr[i], i);
        }

        if (n == 0)
            return false;

        for (int i = 0; i < size; i++) {
            int sum = n + arr[i];
            if (map.containsKey(sum)) {
                return true;
            }
        }
        return false;
    }
}
