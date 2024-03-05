package coding_practice.recursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> list = permute(nums);
        for (List<Integer> outerList : list) {
            for (Integer element : outerList) {
                System.out.print(element + " ");
            }
            System.out.println(); // Move to the next line after each inner list
        }
    }

    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();

        backTrack(ans,new ArrayList<>(),nums);

        return ans;
    }

    private static void backTrack(List<List<Integer>> ans, List<Integer> arrayList, int[] nums) {
    
        if(arrayList.size() == nums.length){
            ans.add(new ArrayList<>(arrayList));
        }
        else{
            for(int i : nums){
                if(arrayList.contains(i)) continue;
                arrayList.add(i);
                backTrack(ans, arrayList, nums);
                arrayList.remove(arrayList.size()-1);
            }
        }

    }
}
