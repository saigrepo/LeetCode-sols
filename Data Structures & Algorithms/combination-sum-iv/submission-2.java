class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        //Arrays.fill(dp, -1);
        dp[0]=1;
        Arrays.sort(nums);
        for(int i=1;i<=target;i++) {
            for(int nxt: nums) {
                if(i-nxt<0) continue;
                dp[i] += dp[i-nxt];
            }
        }
        //dfs(nums, target, dp);
        System.out.println(Arrays.toString(dp));
        return dp[target];
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