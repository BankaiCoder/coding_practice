package coding_practice.arrays;

public class RangeAddition {
    public static void main(String[] args) {
        int[][] arr = { {1,3,2},
                {2,4,3},
                {0,2,-2}};
                int length = 5;

                int[] res = addition(length, arr);

                for(int i=0;i<res.length;i++){
                    System.out.print(res[i]+" ");
                }
    }

    public static int[] addition(int length, int[][] queries) {
        int[] res = new int[length];

        // provide impact to res
        for (int q = 0; q < queries.length; q++) {
            int st = queries[q][0];
            int end = queries[q][1];
            int inc = queries[q][2];

            res[st] += inc;
            if (end + 1 < length) {
                res[end + 1] -= inc;
            }
        }

        int sum = 0;
        // prefix sum
        for (int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }
}
