class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[][] costmap = new int[3][2];
        costmap[0] = new int[] {1, costs[0]};
        costmap[1] = new int[] {7, costs[1]};
        costmap[2] = new int[] {30, costs[2]};

        int[] dp = new int[days.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[days.length] = 0;
        for (int i = days.length-1; i>=0 ; i--) {
            int minCost = Integer.MAX_VALUE;
            for (int[] cost : costmap) {
                int day = days[i], nxtIdx = i;
                int nextDay = day + cost[0];
                while (nxtIdx < days.length && days[nxtIdx] < nextDay) nxtIdx++;
                int take = dp[nxtIdx];
                if (take != Integer.MAX_VALUE)
                    minCost = Math.min(minCost, take + cost[1]);
            }
            dp[i] = minCost;
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    int dfs(int[] days, int[][] costs, int idx, int[] dp) {
        if (idx == days.length)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int minCost = Integer.MAX_VALUE;

        for (int[] cost : costs) {
            int day = days[idx], nxtIdx = idx;
            int nextDay = day + cost[0];
            while (nxtIdx < days.length && days[nxtIdx] < nextDay) nxtIdx++;
            int take = dfs(days, costs, nxtIdx, dp);
            if (take != Integer.MAX_VALUE)
                minCost = Math.min(minCost, take + cost[1]);
        }

        return dp[idx] = minCost;
    }
}