package coding_practice.sortingandTwoPointers;

public class containerWithMoreWater {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(trap(arr));
    }

    public static int trap(int[] arr){
        int left = 0;
        int right = arr.length-1;
        int maxArea = 0;

        while (left < right) {
            int area = Math.min(arr[left], arr[right]) * (right-left);//-->length * breadth
            maxArea = Math.max(maxArea, area);

            if(arr[left] < arr[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
    }
}
