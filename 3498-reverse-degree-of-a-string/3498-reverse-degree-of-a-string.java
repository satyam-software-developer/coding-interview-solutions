class Solution {
    public int reverseDegree(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int value = 'z' - s.charAt(i) + 1;
            sum += value * (i + 1);
        }

        return sum;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna