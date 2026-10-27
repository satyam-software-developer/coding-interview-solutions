class Solution {
    public int getMaxWeight(String s) {
        int n = s.length();
        int prev2 = 0;
        int prev1 = 0;

        for (int i = 1; i < n; i++) {
            int gain = (s.charAt(i - 1) != s.charAt(i)) ? 2 : 1;
            int curr = Math.max(prev1, prev2 + gain);
            prev2 = prev1;
            prev1 = curr;
        }

        return n + prev1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna