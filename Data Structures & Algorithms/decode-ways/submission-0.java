class Solution {
    public int numDecodings(String s) {
        //
        if(s.charAt(0)=='0') return 0;
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0]=dp[1]=1;
        for(int i=2;i<=len;i++) {
            int charOne = Integer.parseInt(s.substring(i-1,i));
            int twoChar = Integer.parseInt(s.substring(i-2,i));
            if(1<=charOne && charOne<=9) dp[i]+=dp[i-1];
            if(10<=twoChar && twoChar<=26) dp[i]+=dp[i-2];
        }
        return dp[len];
    }
}
