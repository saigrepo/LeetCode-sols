class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        return dfs(nums, target, dp);
    }

    int dfs(int[] arr, int tar, int[] dp) {
        if(tar==0) return 1;
        if(tar<0) return 0;

        if(dp[tar]!=-1) return dp[tar];

        int res=0;
        for(int nxt: arr) {
            res+=dfs(arr, tar-nxt, dp);
        }

        return dp[tar]=res;
    }
}