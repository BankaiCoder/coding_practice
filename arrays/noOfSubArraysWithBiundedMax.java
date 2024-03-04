 package coding_practice.arrays;

public class noOfSubArraysWithBiundedMax {
    public static void main(String[] args) {
        int[] arr = {2,9,2,5,6};
        int left = 2;
        int right = 8;

        System.out.println(subArray(arr, left, right));
    }

    public static int subArray(int[] arr,int left,int right){
        int n = arr.length;
        int start = 0;
        int end = 0;

        int ansCount = 0;
        int prevCount = 0;

        while(end < n){
            if(left <= arr[end] && arr[end] <= right){
                prevCount = end - start + 1;
                ansCount += prevCount;
            }
            else if(arr[end] < left){
                ansCount += prevCount;
            }
            else{
                start = end + 1;
                prevCount = 0;
            }
            end++;
        }
        return ansCount;
    }
}
