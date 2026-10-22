class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        int k = nums[0];
        boolean forward = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] != (k + i) % n) {
                forward = false;
                break;
            }
        }

        if (forward) {
            if (k == 0) return 0;
            return Math.min(n - k, k + 2);
        }

        k = (n - 1 - nums[0] + n) % n;
        boolean reverse = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] != (n - 1 - (i + k) % n + n) % n) {
                reverse = false;
                break;
            }
        }

        if (reverse) {
            return Math.min(k + 1, n - k + 1);
        }

        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna