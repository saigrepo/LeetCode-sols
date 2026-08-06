class Solution {
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        int len = nums.length, max=0;
        dp = new int[len];
        Arrays.fill(dp, 1);
        for(int i=0;i<len;i++) {
            for(int j=0;j<i;j++) {
                if(nums[j]<nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
       System.out.println( Arrays.toString(dp));
        return Math.max(max, dp[len-1]);
    }

    //plain recursion
    // int rec(int[] arr, int idx, int prev) {
    //     if(idx>arr.length) return -1;
    //     if(idx==arr.length) return 0;

    //     if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];

    //     int skip = rec(arr, idx+1, prev);

    //     if(prev==-1 || arr[prev]<arr[idx]) {
    //         skip = Math.max(skip, 1 + rec(arr, idx+1, idx));
    //     }
    //     return dp[idx][prev+1]=skip;
    // }
}
