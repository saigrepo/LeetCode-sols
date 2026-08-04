class Solution {
    int[] dp;
    public int numDecodings(String s) {
        //
        // if(s.charAt(0)=='0') return 0;
        // int len = s.length();
        // int[] dp = new int[len+1];
        // dp[0]=dp[1]=1;
        // for(int i=2;i<=len;i++) {
        //     int charOne = Integer.parseInt(s.substring(i-1,i));
        //     int twoChar = Integer.parseInt(s.substring(i-2,i));
        //     if(1<=charOne && charOne<=9) dp[i]+=dp[i-1];
        //     if(10<=twoChar && twoChar<=26) dp[i]+=dp[i-2];
        // }
        dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return rec(s, 0);
    }

    //recursion

    int rec(String s, int idx) {
        if(idx==s.length()) return 1;
        if(s.charAt(idx)=='0') return 0;
        if(dp[idx]!=-1) return dp[idx];
        int oneChar = rec(s, idx+1);
        if(idx<s.length()-1 && (s.charAt(idx)=='1' || (s.charAt(idx)=='2' && s.charAt(idx+1)<'7'))) {
            int twoChar = rec(s, idx+2);
            oneChar += twoChar;
        }
        return dp[idx]=oneChar;
    }
}
