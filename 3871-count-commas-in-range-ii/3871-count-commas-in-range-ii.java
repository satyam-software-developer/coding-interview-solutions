class Solution {
    public long countCommas(long n) {
        long ans = 0;

        for (long p = 1000; p <= n; p *= 1000) {
            ans += n - p + 1;

            if (p > n / 1000) {
                break;
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna