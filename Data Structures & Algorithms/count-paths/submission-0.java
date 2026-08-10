class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        return dfs(dp, m, n, 0, 0);
    }

    int dfs(int[][] dp, int m, int n, int row, int col) {
        if(row<0 || row>=m || col<0 || col>=n) return 0;

        if(row==m-1 && col==n-1) return 1;

        if(dp[row][col]!=-1) return dp[row][col];

        int right = dfs(dp, m, n, row, col+1);
        int down = dfs(dp, m, n, row+1, col);

        return dp[row][col]=right + down;
    }
}
