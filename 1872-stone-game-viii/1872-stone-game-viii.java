class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        long[] prefix = new long[n];

        prefix[0] = stones[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }

        long best = prefix[n - 1];

        for (int i = n - 2; i >= 1; i--) {
            best = Math.max(best, prefix[i] - best);
        }

        return (int) best;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna