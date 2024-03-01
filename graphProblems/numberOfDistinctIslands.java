package coding_practice.graphProblems;

import java.util.HashSet;
import java.util.Set;

public class numberOfDistinctIslands {

public static StringBuilder psf = new StringBuilder();


    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 0, 1, 1},
        {0, 0, 0, 1, 1}};
        System.out.println(countDistinct(grid));
    }
    public static int countDistinct(int[][] grid){
        Set<String> s = new HashSet<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    psf = new StringBuilder();
                    dfs(grid,i,j,"x");
                    s.add(psf.toString());
                }
            }
        }
        return s.size();

    }
    private static void dfs(int[][] grid, int row, int col, String direction) {
       if(row < 0 || row >=grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1){
        return;
       }

       grid[row][col] = 0;
       psf.append(direction);
       dfs(grid, row-1, col, "u");
       dfs(grid, row+1, col, "d");
       dfs(grid, row, col-1, "l");
       dfs(grid, row, col+1, "r");
    }
}
