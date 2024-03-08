package coding_practice.arrays;

import java.util.Arrays;

public class Candy {
   public static void main(String[] args) {
        int[] arr = {1,0,2};
        System.out.println(getMaxCandyCount(arr));
   }
   //problem statement says if the one element is greater then the prev or the next element it will have 
   //candy the others candy count plus its candy counts
   //we will use two arrays first to compare with left element then the other one right
   public static int getMaxCandyCount(int[] arr){
    int[] left = new int[arr.length];
    int[] right = new int[arr.length];
    int total[] = new int[arr.length];

    Arrays.fill(left, 1);
    Arrays.fill(right,1);

    for(int i=1;i<arr.length;i++){
        if(arr[i] > arr[i-1]){
            left[i] = left[i-1] + 1;
        }
    }
    for(int i=arr.length-2;i>=0;i--){
        if(arr[i] > arr[i+1]){
            right[i] = right[i+1]+1;
        }
    }
    for(int i=0;i<arr.length;i++){
        total[i] = Math.max(left[i], right[i]);
    }
    int sum = Arrays.stream(total).sum();

    return sum;
   }
}
