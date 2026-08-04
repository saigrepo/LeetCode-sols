class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount+1];
        Arrays.fill(dp, -2);
    
        int res = rec(coins, amount);
        //System.out.println(Arrays.toString(dp));
        return res==Integer.MAX_VALUE ? -1 : res;
    }

    //take dont take type

    int rec(int[] arr, int amt) {
        if(amt<0) return Integer.MAX_VALUE;

        if(amt==0) return 0;

        if(dp[amt]!=-2) return dp[amt];

        int res = Integer.MAX_VALUE;

        for(int ct: arr) {
            int take = rec(arr, amt-ct);
            if(take!=Integer.MAX_VALUE) res = Math.min(res, take+1);
        }

        return dp[amt] = res;
    }

    int rec(int[] arr, int idx, int amt) {
        if(amt<0) return Integer.MAX_VALUE;
        if(idx>=arr.length) return Integer.MAX_VALUE;

        if(amt==0) return 0;
        if(dp[amt]!=Integer.MAX_VALUE) return dp[amt];

        int take = rec(arr, idx, amt-arr[idx]);
        if(take!=Integer.MAX_VALUE) take+=1;
        int skip = rec(arr, idx+1, amt);

        return dp[amt]=Math.min(take, skip);

    }
}
