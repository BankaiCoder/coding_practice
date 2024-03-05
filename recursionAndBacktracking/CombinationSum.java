package coding_practice.recursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2,3,5};
        int target = 8;
        List<List<Integer>> list = cobmSum(arr, target);

        for(List<Integer> ans : list){
            for(Object i : ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> cobmSum(int[] arr, int target) {
        List<List<Integer>> comb = new ArrayList<>();

        generateCombination(0, arr, new ArrayList<>(), comb, target);

        return comb;
    }

    private static void generateCombination(int start, int[] arr, ArrayList<Integer> current, List<List<Integer>> comb,
            int target) {

        if (target == 0) {
            comb.add(new ArrayList<>(current));
        }
        if (target < 0)
            return;

        for (int i = start; i < arr.length; i++) {
            current.add(arr[i]);
            generateCombination(i, arr, current, comb, target - arr[i]);
            current.remove(current.size() - 1);
        }

    }
}
