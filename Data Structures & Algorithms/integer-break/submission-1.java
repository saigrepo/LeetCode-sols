class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1]=1;
        for(int num=2;num<=n;num++) {
            dp[num] = num==n ? 0 : num;
            for(int i=1;i<num;i++) {
                dp[num] = Math.max(dp[num], dp[i]*dp[num-i]);
            }
        }
        return dp[n];
    }

    int dfs(int tar, int n) {
        if(map.containsKey(tar)) return map.get(tar);

        int res= (tar==n) ? 0 : tar;
        for(int k=1;k<tar;k++) {
            int temp = dfs(k,n) * dfs(tar-k,n);
            res = Math.max(temp, res);
        }
        map.put(tar, res);
        return res;
    }
}