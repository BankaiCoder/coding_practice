package coding_practice.sortingandTwoPointers;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
public class threeSum {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};

        List<List<Integer>> list = thrSum(arr);

        for(List<Integer> outerList : list){
            for(Object i : outerList){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> thrSum(int[] arr){
        Arrays.sort(arr);

        Set<List<Integer>> set = new HashSet<>();

        if(arr == null && arr.length<3){
            return new ArrayList<>();
        }


        for(int i=0;i<arr.length-2;i++){

            int left = i+1;
            int right = arr.length-1;

            while(left<right){
                int sum = arr[i]+arr[left]+arr[right];


                if(sum == 0){
                    set.add(Arrays.asList(arr[i],arr[left],arr[right]));
                    left++;
                    right--;
                }
                else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }

        }
        return new ArrayList<>(set);
    }
}
