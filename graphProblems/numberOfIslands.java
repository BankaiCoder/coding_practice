package coding_practice.graphProblems;

public class numberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','0'},
                         {'0','0','0','0','0'}};
                        System.out.println(numsIsland(grid));
        
    }

    public static int numsIsland(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int landCount = 0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j, row, col);
                    landCount++;
                }
            }
        }
        return landCount;
    }

    public static void dfs(char[][] grid, int i, int j, int row, int col) {
        if(i<0 || i>=row || j<0 || j>=col || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';//-->you can use any number change here and change in the base case too

        dfs(grid, i+1, j, row, col);
        dfs(grid, i-1, j, row, col);
        dfs(grid, i, j+1, row, col);
        dfs(grid, i, j-1, row, col);
    }
}
