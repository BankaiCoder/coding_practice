package coding_practice.recursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> list = getSum2(arr, target);

        for(List<Integer> ans : list){
            for(Object i : ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> getSum2(int[] arr, int target){
        List<List<Integer>> comb = new ArrayList<>();
        Arrays.sort(arr);
        generateCombination(0, arr, new ArrayList<>(), comb, target);
        return comb;
    }

    private static void generateCombination(int start, int[] arr, ArrayList<Integer> current, List<List<Integer>> comb,
            int target) {

                if(target == 0){
                    comb.add(new ArrayList<>(current));
                    return;
                }

                for(int i=start;i<arr.length;i++){
                    if(i>start && arr[i] == arr[i-1]) continue;

                    if(target - arr[i] >= 0){//-->memoization
                        current.add(arr[i]);
                        generateCombination(i+1, arr, current, comb, target-arr[i]);
                        current.remove(current.size()-1);
                    }
                }


            }
}
