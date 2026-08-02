class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int len = nums.length;
        dp = new int[len];
        Arrays.fill(dp,-1);
        if(len<=1) return nums[0];
        dp[0] = nums[0];
        for(int i=1;i<len;i++) {
            if(i==1) {
                dp[i] = Math.max(dp[i-1], nums[i]);
                continue;
            }
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);

        }
        return dp[len-1];
        //return rec(nums, len-1);
    }

    int rec(int[] arr, int idx) {
        if(idx<0) return 0;
        if(idx==0) return arr[0];
        if(dp[idx]!=-1) return dp[idx];

        int notTake = rec(arr, idx-1);
        int take = arr[idx] + rec(arr, idx-2);

        return dp[idx] = Math.max(notTake, take);
    }
}
