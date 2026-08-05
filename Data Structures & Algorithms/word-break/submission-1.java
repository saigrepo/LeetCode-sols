class Solution {
    int[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return rec(s, wordDict, 0);
    }

    //brute force recursion
    //now memoize
    boolean rec(String s, List<String> words, int idx) {
        if(idx>s.length()) return false;
        if(idx==s.length()) return true;

        if(dp[idx]!=-1) return dp[idx]==1 ? true : false;

        for(String str: words) {
            if(s.startsWith(str, idx)) {
                boolean take = rec(s, words, idx+str.length());
                if(take) {
                    dp[idx]=1;
                    return true;
                }
            }
        }
        dp[idx]= 0;
        return false;
    }
}
