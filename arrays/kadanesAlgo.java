package coding_practice.arrays;

public class kadanesAlgo {
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(kadanes(arr));
        System.out.println(kadanesII(arr));
    }

    // 2nd way
    public static int kadanesII(int[] arr) {
        int max = 0;
        int maxS = arr[0];

        for (int i = 0; i < arr.length; i++) {
            max += arr[i];

            maxS = max > maxS ? max : maxS;

            if (max < 0)
                max = 0;

        }
        return maxS;
    }

    // one way
    public static int kadanes(int[] arr) {
        int max = 0;
        int maxS = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            max += arr[i];

            if (max > maxS) {
                maxS = max;
            }
            if (max < 0)
                max = 0;
        }
        return maxS;
    }
}
