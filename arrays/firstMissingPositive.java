package coding_practice.arrays;

public class firstMissingPositive {
    public static void main(String[] args) {
        int[] arr = {7,8,9,11,12};
        System.out.println(missing(arr));
    }

    public static int missing(int[] arr) {

        int n = arr.length;
        boolean one = false;// --> this is bcs 1 is the least element in an array if 1 is missing simply
                            // turn return 1

        // Mark out of range elements and mark presence of one

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1)
                one = true;

            if (arr[i] < 1 || arr[i] > n) {
                arr[i] = 1;
            }
        }
        if (one == false)
            return 1;// after first step is one remains false that means one is mising

        // Map elements with index
        for (int i = 0; i < n; i++) {
            int indx = Math.abs(arr[i]);
            arr[indx - 1] = -Math.abs(arr[indx - 1]);
        }
        // Find out missing integer
        for (int i = 0; i < n; i++) {

            //if element is +ve that means indx+1 is missing from array
            if (arr[i] >= 0)
                return i + 1;
        }
        return n + 1;
    }
}
