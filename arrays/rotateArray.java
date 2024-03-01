package coding_practice.arrays;
//package coding_practice.graphs;

public class rotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;

        //rotate whole array-->7,6,5,4,3,2,1
        rotate(arr, 0,arr.length-1);

        //rotate uppto k-->5,6,7,4,3,2,1
        k = k%arr.length;
        rotate(arr, 0, k-1);

        //rotate the array from k to arr length-->5,6,7,1,2,3,4
        rotate(arr, k, arr.length-1);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

public static void rotate(int[] arr,int s,int e){
    while(s<e){
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
        s++;
        e--;
    }
}

}
