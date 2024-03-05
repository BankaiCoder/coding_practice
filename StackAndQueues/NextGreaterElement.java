package coding_practice.StackAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        int[] ans = nextGreaterelement(nums1, nums2);
        for(int i : ans){
            System.out.print(i+" ");
        }
    }

    public static int[] nextGreaterelement(int[] nums1, int[] nums2) {
          int[] ans = new int[nums1.length];
        Map<Integer, Integer> nextGreaterMap = findNextGreater(nums2);

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nextGreaterMap.get(nums1[i]);
        }

        return ans;
    }

    private static Map<Integer, Integer> findNextGreater(int[] nums) {
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }

            nextGreaterMap.put(nums[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums[i]);
        }

        return nextGreaterMap;
    }
}