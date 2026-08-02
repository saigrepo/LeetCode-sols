class Solution {
    int[] dp;
    public int climbStairs(int n) {
        //_ _ _
       dp = new int[n+1];
       Arrays.fill(dp, -1);
     return rec(n);
    }

    int rec(int n) {
        if(n<=1) return 1;

        if(dp[n]!=-1) return dp[n];

        int two = rec(n-2);
        int one = rec(n-1);

        return dp[n] = (one + two);
    }
}
