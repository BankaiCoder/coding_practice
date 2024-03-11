package coding_practice.binarySearch;


public class ShipWithinDays {
    public static void main(String[] args) {
        int[]  weights = {3,2,2,4,1,4};
        int days = 3;

        System.out.println(shipInDays(weights, days));
    }

    public static int shipInDays(int[] weights, int days){
        int low = maxWeight(weights);
        int high = getSum(weights);

        while(low < high){
            int mid = low+(high-low)/2;

            if(currentCapacity(weights,days,mid)){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }

    private static boolean currentCapacity(int[] weights, int days, int capacity) {
        int daysNeeded = 1;
        int crrntCapacity = 0;

        for(int  weight : weights){
            if(crrntCapacity + weight > capacity){
                daysNeeded++;
                crrntCapacity = 0;
            }
            crrntCapacity += weight;
        }

        return daysNeeded <= days;
    }

public static int maxWeight(int[]  weights){
    int maxWeight = 0;
    for(int weight : weights){
        maxWeight = Math.max(maxWeight, weight);
    }
    return maxWeight;
}

public static int getSum(int[] weights){
    int sum =0;

    for(int weight : weights){
        sum+=weight;
    }
    return sum;
}

}
