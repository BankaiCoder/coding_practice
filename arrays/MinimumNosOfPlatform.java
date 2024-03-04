package coding_practice.arrays;

import java.util.Arrays;



public class MinimumNosOfPlatform {
    public static void main(String[] args) {
        int[] arr = {1010,1030,1050,1100,1500,1800};
        int[] dep = {1050,1200,1120,1130,1900,2000};

        System.out.println(findPlatform(arr, dep));
    }

    public static int findPlatform(int[] arr, int[] dep){
        //sort arrival and departure
        Arrays.sort(arr);
        Arrays.sort(dep);
        //maintain maxTrain a particular time
        int n = arr.length;
        int i = 0;//-->pointing to arrival time
        int j = 0;//-->pointing to departure time

        int maxTrain = 0;
        int platFrom = 0;

        while(i<n && j<n){
            if(arr[i] <= dep[j]){
                maxTrain++;
                i++;
            }else{
                maxTrain--;
                j++;
            }
            platFrom = Math.max(platFrom,maxTrain);
        }

        return platFrom;
    }
}
