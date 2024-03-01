package coding_practice.graphProblems;

import java.util.LinkedList;
import java.util.Queue;

public class rottenOranges {

/**
 * Pair
 */
 static class Pair {
int row;
int col;
int time;
public Pair(int r, int c, int t){
    this.col = c;
    this.row = r;
    this.time = t;
}
    
}

    public static void main(String[] args) {
        int[][] arr = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(rotten(arr));
    }
    public static int rotten(int[][] arr){
        Queue<Pair> q = new LinkedList<>();
        int N = arr.length;
        int M = arr[0].length;
        int ans = -1;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j] == 2){
                    q.add(new Pair(i, j,0));
                }
            }
        }

        while(!q.isEmpty()){
            Pair rem = q.remove();
            int r = rem.row;
            int c = rem.col;
            int t = rem.time;
            ans = t;

            if(r-1 > 0 && arr[r-1][c] == 1){
                q.add(new Pair(r-1, c, t+1));
                arr[r-1][c] = 2;
            }
            if(r+1 < N && arr[r+1][c] == 1){
                q.add(new Pair(r+1, c, t+1));
                arr[r+1][c] = 2;
            }
            if(c-1 > 0 && arr[r][c-1] == 1){
                q.add(new Pair(r, c-1, t+1));
                arr[r][c-1] = 2;
            }
            if(c+1 < M && arr[r][c+1] == 1){
                q.add(new Pair(r, c+1, t+1));
                arr[r][c+1] = 2;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j] == 1){
                    return -1;
                }
            }
        }
        return ans == -1 ? 0 : ans;
    }
}
