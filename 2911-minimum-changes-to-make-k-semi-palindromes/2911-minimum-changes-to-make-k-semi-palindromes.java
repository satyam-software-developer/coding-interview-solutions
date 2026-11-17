class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len <= n; l++) {
                int r = l + len - 1;
                cost[l][r] = Integer.MAX_VALUE;

                for (int d = 1; d < len; d++) {
                    if (len % d != 0) {
                        continue;
                    }

                    int changes = 0;

                    for (int j = 0; j < d; j++) {
                        int left = l + j;
                        int right = l + j + ((len - 1 - j) / d) * d;

                        while (left < right) {
                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }

                            left += d;
                            right -= d;
                        }
                    }

                    cost[l][r] = Math.min(cost[l][r], changes);
                }
            }
        }

        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dp[0][0] = 0;

        for (int p = 1; p <= k; p++) {
            for (int i = 2 * p; i <= n; i++) {
                for (int j = 2 * (p - 1); j <= i - 2; j++) {
                    if (dp[p - 1][j] != Integer.MAX_VALUE) {
                        dp[p][i] = Math.min(dp[p][i],
                                dp[p - 1][j] + cost[j][i - 1]);
                    }
                }
            }
        }

        return dp[k][n];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna