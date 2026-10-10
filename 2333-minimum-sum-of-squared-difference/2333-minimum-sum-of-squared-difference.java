class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long operations = (long) k1 + k2;
        int n = nums1.length;
        int[] diff = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        if (operations >= (long) max * n) {
            return 0;
        }

        long[] freq = new long[max + 1];

        for (int d : diff) {
            freq[d]++;
        }

        for (int d = max; d > 0 && operations > 0; d--) {
            long count = Math.min(freq[d], operations);
            freq[d] -= count;
            freq[d - 1] += count;
            operations -= count;
        }

        long result = 0;

        for (int d = 1; d <= max; d++) {
            result += freq[d] * d * d;
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna