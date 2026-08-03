class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int count=0;
        for(int i=0;i<len;i++) {
            int l=i,r=i;
            while(l>=0 && r<len && s.charAt(l)==s.charAt(r)) {
                count++;
                l-=1;
                r+=1;
            }
            l=i;r=i+1;
            while(l>=0 && r<len && s.charAt(l)==s.charAt(r)) {
                count++;
                l-=1;
                r+=1;
            }
        }
        return count;
    }
}
