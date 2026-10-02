class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;
        
        int[][] dp = new int[m + 1][n + 1];
        
        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            
            dp[x][y] = -1;
        }
        
        dp[1][1] = 1;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                
                if (dp[i][j] == -1) {
                    continue;
                }
                
                if (i == 1 && j == 1) {
                    continue;
                }
                
                int right = 0;
                int down = 0;
                
                if (i > 1 && dp[i - 1][j] != -1) {
                    right = dp[i - 1][j];
                }
                
                if (j > 1 && dp[i][j - 1] != -1) {
                    down = dp[i][j - 1];
                }
                
                dp[i][j] = (right + down) % mod;
            }
        }
        
        return dp[m][n];
    }
}