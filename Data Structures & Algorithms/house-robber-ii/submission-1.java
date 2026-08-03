class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len==1) return nums[0];
        if(len==2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[len];
        //Arrays.fill(dp, -1);
        //consider first
        dp[0] = nums[0];
        for(int i=1;i<len-1;i++) {
            dp[i] = Math.max(dp[i-1], (i-2 < 0 ? 0 : dp[i-2]) + nums[i]);
        }
        int consFirst = dp[len-2];
        Arrays.fill(dp, 0);
        dp[1] = nums[1];
        for(int i=2;i<len;i++) {
            dp[i] = Math.max(dp[i-1], (i-2 < 0 ? 0 : dp[i-2]) + nums[i]);
        }
        //System.out.println(Arrays.toString(dp));

        return Math.max(consFirst, dp[len-1]);
    }
}
