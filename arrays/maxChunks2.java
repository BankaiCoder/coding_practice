package coding_practice.arrays;


//This is different bcs elements can be distinct in the first one the elments are someway equal to the index
//so it was easy to locate and sort them


public class maxChunks2 {
    public static void main(String[] args) {
        int[] arr = {2,1,3,4,4};
        System.out.println(chunks2(arr));
    }
    public static int chunks2(int[] arr){

        int n = arr.length;
       int[] lmax = new int[n];
       int[] rmin = new int[n];
        int count = 0;

        lmax[0] = arr[0];
        for(int i=1;i<n;i++){
            lmax[i] = Math.max(arr[i], lmax[i-1]);
        }

        rmin[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            rmin[i] = Math.min(arr[i], rmin[i+1]);
        }

        for(int i=0;i<n-1;i++){
            if(lmax[i] <= rmin[i+1]){
                count++;
            }
        }
        return count+1;

    }
}
