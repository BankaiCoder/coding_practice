package coding_practice.sortingandTwoPointers;

import java.util.HashMap;
import java.util.Map;

public class twoSum {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int targ = 9;

        int[] res = TSum(arr, targ);
        for(int i=0;i<res.length;i++){
            System.out.print("["+res[i]+"]");
        }
        
    }

    public static int[] TSum(int[] arr, int targ){
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            int complememnt = targ-arr[i];

            if(map.containsKey(complememnt)){
                return new int[]{map.get(complememnt),i};
            }
            
            map.put(arr[i], i);
        }
        throw new IllegalArgumentException("no two sum found");
    }
}
