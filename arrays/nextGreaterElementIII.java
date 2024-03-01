package coding_practice.arrays;

public class nextGreaterElementIII {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(nextGreater(n));
    }

    public static int nextGreater(int n) {
        char[] arr = String.valueOf(n).toCharArray();

        // Find the first digit that is smaller than the digit to its right
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        // If no such digit is found, the number is the largest possible permutation
        if (i == -1) {
            return -1;
        }
        // Find the smallest digit to the right of i that is greater than digits[i]
        int j = arr.length - 1;
        while (arr[i] >= arr[j]) {
            j--;
        }

        // Swap the two digits
        swap(arr, i, j);

        // Reverse the digits to the right of i
        reverse(arr, i + 1, arr.length - 1);

        try {
            return Integer.parseInt(new String(arr));
        } catch (Exception e) {
            return -1;// Return -1 if the result doesn't fit in a 32-bit integer
        }
    }

    private static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
