class Solution {
    public String longestPalindrome(String s) {
        //trying two pointer solution for a DP problem : phew

        int len = s.length();
        String res = "";
        for(int i=0;i<len;i++) {
            int l=i,r=i;
            while(l>=0 && r<len && s.charAt(l)==s.charAt(r)) {
                if(r-l+1 > res.length()) {
                    res = s.substring(l,r+1);
                }
                l-=1;
                r+=1;
            }
            l=i;
            r=i+1;
            while(l>=0 && r<len && s.charAt(l)==s.charAt(r)) {
                if(r-l+1 > res.length()) {
                    res = s.substring(l,r+1);
                }
                l-=1;
                r+=1;
            }
        }
        return res;
    }
}
