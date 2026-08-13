class Solution {
            HashMap<Integer, Integer> map = new HashMap<>();

    public int integerBreak(int n) {
        return dfs(n,n);
    }

    int dfs(int tar, int n) {
        if(map.containsKey(tar)) return map.get(tar);

        int res= (tar==n) ? 0 : tar;
        for(int k=1;k<tar;k++) {
            int temp = dfs(k,n) * dfs(tar-k,n);
            res = Math.max(temp, res);
        }
        map.put(tar, res);
        return res;
    }
}