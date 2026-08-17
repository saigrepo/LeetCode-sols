class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int left = text1.length(), right = text2.length();
        int[][] dp = new int[left][right];
        for(int[] nst: dp) Arrays.fill(nst, -1);
        return rec(text1, text2, 0,0, dp);
    }

    int rec(String left, String right, int l, int r, int[][] dp) {
        if(l == left.length() || r == right.length()) return 0;

        if(dp[l][r]!=-1) return dp[l][r];

        if(left.charAt(l)==right.charAt(r)) {
            return dp[l][r] = 1 + rec(left, right, l+1, r+1, dp);
        }
        
        return dp[l][r] = Math.max(rec(left, right, l+1, r, dp), rec(left, right, l,r+1, dp));

    }
}
