class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int len = grid.length, cLen = grid[0].length;
        int[][] dp = new int[len][cLen];
        for(int[] d: dp) Arrays.fill(d, -1);
        return dfs(grid, 0,0, dp);
    }

    //dfs

    int dfs(int[][] grid, int row, int col, int[][] dp) {
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]==1) return 0;
        if(row==grid.length-1 && col==grid[0].length-1) return 1;

        if(dp[row][col]!=-1) return dp[row][col];

        return dp[row][col] = dfs(grid, row, col+1,dp) + dfs(grid, row+1, col, dp);
    }
}