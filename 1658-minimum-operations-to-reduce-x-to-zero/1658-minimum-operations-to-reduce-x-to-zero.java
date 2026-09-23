class Solution {
    public int minOperations(int[] nums, int x) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        long target = sum - x;
        if (target < 0)
            return -1;
        if (target == 0)
            return nums.length;

        int left = 0;
        long curr = 0;
        int maxLen = -1;

        for (int right = 0; right < nums.length; right++) {
            curr += nums[right];

            while (left <= right && curr > target) {
                curr -= nums[left++];
            }

            if (curr == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna