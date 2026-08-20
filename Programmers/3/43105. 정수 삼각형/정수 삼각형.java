class Solution {
    public int solution(int[][] triangle) {
        // 누적 최댓값 관리할 배열
        int[][] dp = new int[triangle.length][triangle.length];

        dp[0][0] = triangle[0][0];

        // 각 위치까지 최대 누적합 계산
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i-1][0] + triangle[i][0];
                } else if (i == j) {
                    dp[i][i] = dp[i-1][i-1] + triangle[i][i];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }

        int max = 0;
        for (int value : dp[triangle.length - 1]) {
            max = Math.max(value, max);
        }

        return max;

    }
}