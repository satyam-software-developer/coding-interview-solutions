class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] present = new boolean[101];

        for (int num : nums) {
            if (num <= 100) {
                present[num] = true;
            }
        }

        for (int multiple = k; multiple <= 100; multiple += k) {
            if (!present[multiple]) {
                return multiple;
            }
        }

        return ((100 / k) + 1) * k;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna