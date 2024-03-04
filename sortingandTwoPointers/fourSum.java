package coding_practice.sortingandTwoPointers;

import java.util.*;

public class fourSum {
    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};


        List<List<Integer>> list = approach2(arr, 0);
        for(List<Integer> ans : list){
            for(Object i : ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    // Brute force Approach--->O(N^4)
    public static List<List<Integer>> approach1(int[] arr, int target) {
        Set<List<Integer>> set = new HashSet<>();
        int n = arr.length;
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < n - 3; i++) {
            //if(i>0 &&  arr[i] == arr[i-1]) continue; //--->Skip same values for index i to avoid duplicate values;
            for (int j = i + 1; j < n - 2; j++) {
                //if(j>i+1 && arr[j] == arr[j-1]) continue; //--->skip same vaues for index j to avoid duplicates;
                for (int k = j + 1; k < n - 1; k++) {
                    //if(k>j+1 && arr[k] == arr[k-1]) continue; //skip same values for index k to avoid duplicates;
                    for (int l = k + 1; l < n; l++) {
                       // if(l>k+1 && arr[l] == arr[l-1]) continue; //skip same values for index l to avoid duplicates;
                        sum = arr[i] + arr[j] + arr[k] + arr[l];
                        if (sum > target) {
                            break;
                        } else if (sum == target) {
                            // ArrayList<Integer> list = new ArrayList<>();//-->this part is same as the below part
                            // list.add(arr[i]);
                            // list.add(arr[j]);
                            // list.add(arr[k]);
                            // list.add(arr[l]);
                            // set.add(list);
                            set.add(Arrays.asList(arr[i],arr[j],arr[k],arr[l]));//this and commented part is same

                        }

                    }
                }
            }
        }

        return new ArrayList<>(set);

    }

// approach using Set--->O(N^3)
public static List<List<Integer>> approach2(int[] arr, int target){
    Set<List<Integer>> set = new HashSet<>();
    int n = arr.length;
    int sum = 0;

    Arrays.sort(arr);

    for(int i=0;i<n-3;i++){
        if(i>0 && arr[i] == arr[i-1]) continue; //-->SKip same elements for index i to avoid duplicates;

        for(int j = i+1;j<n-2;j++){
            if(j>i+1 && arr[j] == arr[j-1]) continue;//-->skip duplicates;

            int left = j+1;
            int right = n-1;

            while (left < right) {
                sum = arr[i]+arr[j]+arr[left]+arr[right];

                if(sum > target){
                    right--;
                }
                else if(sum == target){
                    set.add(Arrays.asList(arr[i],arr[j],arr[left],arr[right]));
                    left++;
                }
                else{
                    left++;
                }
            }
        }
    }
    return new ArrayList<>(set);
}

    // approach using hashMap--->O(N^4)

    public static List<List<Integer>> approach3(int[] arr, int target){

        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;

        if (n < 4)
            return ans;

        Arrays.sort(arr);

        Map<Integer, List<int[]>> map = new HashMap<>();

        // Store all sum pairs in the map
        // Key: SUM, Value: List of index pairs (i, j) where i < j
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int sum = arr[i] + arr[j];
                if (!map.containsKey(sum))
                    map.put(sum, new ArrayList<>());
                map.get(sum).add(new int[]{i, j});
            }
        }

        for (int i = 0; i < n - 1; ++i) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            for (int j = i + 1; j < n; ++j) {
                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;

                int sum = target - arr[i] - arr[j];

                if (map.containsKey(sum)) {
                    for (int[] pair : map.get(sum)) {
                        int k = pair[0];
                        int l = pair[1];

                        if (k > j) {
                            // Maintain the increasing order of indices (i, j, k, l)
                            // Skip duplicates
                            if (!ans.isEmpty() && ans.get(ans.size() - 1).get(0) == arr[i] &&
                                    ans.get(ans.size() - 1).get(1) == arr[j] &&
                                    ans.get(ans.size() - 1).get(2) == arr[k] &&
                                    ans.get(ans.size() - 1).get(3) == arr[l])
                                continue;

                            List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            ans.add(temp);
                        }
                    }
                }
            }
        }

        return ans;

    }

    

}
