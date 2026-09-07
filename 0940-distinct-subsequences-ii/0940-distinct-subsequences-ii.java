class Solution {
    public int distinctSubseqII(String s) {
        final long MOD = 1000000007L;
        long[] dp = new long[26];
        long total = 0;

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            long add = (total + 1) % MOD;
            total = (total + add - dp[idx] + MOD) % MOD;
            dp[idx] = add;
        }

        return (int) total;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna