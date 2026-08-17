class Solution {
    public int minPathSum(int[][] grid) {
        int row=grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        for(int[] nxt: dp) Arrays.fill(nxt, -1);
        return dfs(grid, 0,0, dp);
    }

    int dfs(int[][] grid, int row, int col, int[][] dp) {
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length) return Integer.MAX_VALUE;

        if(row==grid.length-1 && col==grid[0].length-1) return grid[row][col];

        if(dp[row][col]!=-1) return dp[row][col];


        return dp[row][col] = grid[row][col] + Math.min(dfs(grid, row, col+1,dp), dfs(grid, row+1, col,dp));
    }
}