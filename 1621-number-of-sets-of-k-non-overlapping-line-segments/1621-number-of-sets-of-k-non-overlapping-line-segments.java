class Solution {
    public int numberOfSets(int n, int k) {
        final long MOD = 1000000007L;
        long[][] dp = new long[k + 1][n];

        for (int i = 1; i < n; i++) {
            dp[1][i] = (i * (i + 1L)) / 2;
        }

        for (int seg = 2; seg <= k; seg++) {
            long sum = 0;
            for (int i = 1; i < n; i++) {
                sum = (sum + dp[seg - 1][i - 1]) % MOD;
                dp[seg][i] = (dp[seg][i - 1] + sum) % MOD;
            }
        }

        return (int) dp[k][n - 1];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna