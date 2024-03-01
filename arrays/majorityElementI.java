package coding_practice.arrays;

public class majorityElementI {
    public static void main(String[] args) {
        int[] arr = {3,2,3};
        System.out.println(majority(arr));
    }
    public static int majority(int[] arr){
        int n = arr.length;
        int maj = arr[0];
        int count = 1;

        for(int i=1;i<n;i++){
            if(arr[i] == maj){
                count++;
            }else{
                count--;

                if(count == 0){
                    maj = arr[i];
                    count = 1;
                }
            }
        }

        count = 0;
        for(int i : arr){
            if(i == maj){
                count++;
            }
        }

        if(count > n/2){
            return maj;
        }
        else{
            return -1;
        }
    }
}
