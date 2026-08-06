class Solution {
    int[][] dp;
    public boolean canPartition(int[] nums) {
        int len =nums.length;
        int sum = Arrays.stream(nums).reduce(0, (a,b) -> a+b);
        dp = new int[len+1][sum+1];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        if(sum%2!=0) return false;

        return rec(nums, 0,0,sum);
    }

    boolean rec(int[] arr, int idx, int p1, int sum) {
        if(p1==sum) return true;

        if(idx>=arr.length) return false;

        if(dp[idx][sum]!=-1) return dp[idx][sum]==1 ? true : false;

        boolean takeP1 = rec(arr, idx+1, p1+arr[idx], sum-arr[idx]);
        boolean skip = rec(arr, idx+1, p1, sum);

        boolean res = (takeP1 || skip);
        dp[idx][sum] = res ? 1 : 0;

        return res;
    }
}
