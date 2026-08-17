class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int len = grid.length, cLen = grid[0].length;
        int[][] dp = new int[len][cLen];
        // for(int[] d: dp) Arrays.fill(d, -1);
        // dfs(grid, 0,0, dp);
        // 1 1 1
        // 1 2 3
        // 1 1 3
        if (grid[0][0] == 1 || grid[len - 1][cLen - 1] == 1)
            return 0;

        for(int i=0;i<len;i++) {
            if(grid[i][0]==1) break;
            dp[i][0]=1;
        }
        for(int i=0;i<cLen;i++) {
            if(grid[0][i]==1) break;
            dp[0][i]=1;
        }
        for (int r = 1; r < len; r++) {
            for (int c = 1; c < cLen; c++) {
                if (grid[r][c] == 1)
                    dp[r][c] = 0;
                else {
                    dp[r][c] += dp[r - 1][c] + dp[r][c - 1];
                }
            }
        }
        return dp[len - 1][cLen - 1];
    }

    // dfs

    int dfs(int[][] grid, int row, int col, int[][] dp) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
            || grid[row][col] == 1)
            return 0;
        if (row == grid.length - 1 && col == grid[0].length - 1)
            return 1;

        if (dp[row][col] != -1)
            return dp[row][col];

        return dp[row][col] = dfs(grid, row, col + 1, dp) + dfs(grid, row + 1, col, dp);
    }
}