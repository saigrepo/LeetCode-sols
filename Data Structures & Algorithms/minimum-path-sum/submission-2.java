class Solution {
    public int minPathSum(int[][] grid) {
        int row=grid.length, col = grid[0].length;
        int[][] dp = new int[row+1][col+1];
        for(int[] nxt: dp) Arrays.fill(nxt, Integer.MAX_VALUE);
        //System.out.println(Arrays.deepToString(dp));
        for(int i=row-1;i>=0;i--) {
            for(int j=col-1;j>=0;j--) {
                int val = Math.min(dp[i+1][j], dp[i][j+1]);
                if(val!=Integer.MAX_VALUE) dp[i][j] = val + grid[i][j];
                else dp[i][j]= grid[i][j];
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[0][0];
    }

    //[[-2147483642, 6, -2147483643, 2147483647],
    // [9, -2147483640, 6, 2147483647], 
    //[-2147483643, 5, -2147483643, 2147483647], [2147483647, 2147483647, 2147483647, 2147483647]]


    int dfs(int[][] grid, int row, int col, int[][] dp) {
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length) return Integer.MAX_VALUE;

        if(row==grid.length-1 && col==grid[0].length-1) return grid[row][col];

        if(dp[row][col]!=-1) return dp[row][col];


        return dp[row][col] = grid[row][col] + Math.min(dfs(grid, row, col+1,dp), dfs(grid, row+1, col,dp));
    }
}