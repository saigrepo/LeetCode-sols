class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        dp = new int[len][len+1];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        return rec(nums, 0, -1);
    }

    //plain recursion
    int rec(int[] arr, int idx, int prev) {
        if(idx>arr.length) return -1;
        if(idx==arr.length) return 0;

        if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];

        int skip = rec(arr, idx+1, prev);

        if(prev==-1 || arr[prev]<arr[idx]) {
            skip = Math.max(skip, 1 + rec(arr, idx+1, idx));
        }
        return dp[idx][prev+1]=skip;
    }
}
