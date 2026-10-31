class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int mod = 1000000007;

        int[][] right = new int[m][n];
        int[][] down = new int[m][n];

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    int ways = (dp[i][j] + right[i][j] + down[i][j]) % mod;

                    if (i == m - 1 && j == n - 1) {
                        return ways;
                    }

                    if (j + 1 < n) {
                        if (grid[i][j + 1] == 1) {
                            if (i + 1 < m) {
                                down[i + 1][j + 1] =
                                    (down[i + 1][j + 1] + ways) % mod;
                            }
                        } else {
                            dp[i][j + 1] =
                                (dp[i][j + 1] + ways) % mod;
                        }
                    }

                    if (i + 1 < m) {
                        if (grid[i + 1][j] == 1) {
                            if (j + 1 < n) {
                                right[i + 1][j + 1] =
                                    (right[i + 1][j + 1] + ways) % mod;
                            }
                        } else {
                            dp[i + 1][j] =
                                (dp[i + 1][j] + ways) % mod;
                        }
                    }
                } else {
                    if (right[i][j] > 0 && i + 1 < m) {
                        down[i + 1][j] =
                            (down[i + 1][j] + right[i][j]) % mod;
                    }

                    if (down[i][j] > 0 && j + 1 < n) {
                        right[i][j + 1] =
                            (right[i][j + 1] + down[i][j]) % mod;
                    }
                }
            }
        }

        return 0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna