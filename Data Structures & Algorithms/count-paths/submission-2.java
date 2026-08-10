class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // for(int[] d: dp) {
        //     Arrays.fill(d, -1);
        // }
        //dfs(dp, m, n, 0, 0);
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i==0 || j==0) {
                    dp[i][j]=1;
                    continue;
                } 
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
       // System.out.println(Arrays.deepToString(dp));
        return dp[m-1][n-1];
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
