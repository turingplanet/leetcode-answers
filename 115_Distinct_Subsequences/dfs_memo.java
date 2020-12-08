class Solution {
    Integer[][] memo;
    public int numDistinct(String s, String t) {
        memo = new Integer[s.length() + 1][t.length() + 1];
        return dfs(s, t, s.length(), t.length());
    }
    
    private int dfs(String s, String t, int i, int j) {
        if (j == 0) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        int res = 0;
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            res = dfs(s, t, i - 1, j - 1) + dfs(s, t, i - 1, j);
        } else {
            res = dfs(s, t, i - 1, j);
        }
        
        memo[i][j] = res;
        return res;
    }
}