package coding_practice.arrays;

public class maxhunksToMakeSort {
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,4};
        System.out.println(maxChunk(arr));
    }
    public static int maxChunk(int[] arr){
        int max = 0;
        int count = 0;

        for(int i=0;i<arr.length;i++){
            max = Math.max(arr[i], max);

            if(i == max){
                count++;
            }
        }
        
        return count;
    }
}
