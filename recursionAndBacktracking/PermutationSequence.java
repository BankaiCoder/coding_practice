package coding_practice.recursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;



public class PermutationSequence {
    public static void main(String[] args) {
        int n=3, k=3;
        System.out.println(getPermutation(n, k));
    }

//STEPS
//1--> Index = k/(n-1)!
//2-->ans+=char(digits[index])
//3-->erase used digit(as digits are unique in a number)
//4--> new k = k-fact(n-1)*index
//Base : if(n == 1) Add the last digit.
//digits: [1,2,3,4]
//if(k%fact(n-1) == 0) index-=1;


    public static String getPermutation(int n, int k){
        int[] fact = new int[n+1];
        List<Integer> number = new ArrayList<>();
        fact[0]=fact[1]=1;

        for(int i=2;i<fact.length;i++){
            fact[i] = fact[i-1] * i;
        }
        for(int i=1;i<=n;i++)
        number.add(i);

        StringBuilder sb = new StringBuilder();

        while(n>0){
            int index = k/fact[n-1];
            if(k%fact[n-1] == 0) index--;

            sb.append(number.get(index));
            number.remove(index);
            k = k%fact[n-1]==0 ? fact[n-1] : k%fact[n-1];
            n--;
        }
        return sb.toString();
    }
}
