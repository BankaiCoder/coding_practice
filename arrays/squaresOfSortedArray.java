package coding_practice.arrays;

public class squaresOfSortedArray {
    public static void main(String[] args) {
        int[] arr = {-5,-1,2,4,5};
        
        int left = 0;
        int right = arr.length-1;
        int index = arr.length-1;

        int[] result = new int[arr.length];    
        while(left < right){
            int leftS = arr[left] * arr[left];
            int rightS = arr[right] * arr[right];

            if(leftS > rightS){
                result[index] = leftS;
                left++;
            }
            else {
                result[index] = rightS;
                right--;
            }
            index--;
        }

        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }

}
