package coding_practice.arrays;

public class maxProductSubArray {
    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        System.out.println(maxProduct(arr));
    }
    public static int maxProduct(int[] arr){
        int n = arr.length;
        int result = arr[0];
        int maxPro = arr[0];
        int minPro = arr[0];

        for(int i=1;i<n;i++){
            if(arr[i] < 0){
                int temp = maxPro;
                maxPro = minPro;
                minPro = temp;
            }

            maxPro = Math.max(arr[i], maxPro*arr[i]);
            minPro = Math.min(arr[i], minPro*arr[i]);
            result = Math.max(result, maxPro);
        }
        return result;
    }
}
