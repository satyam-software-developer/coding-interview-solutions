class Solution {
    public int maxPackages(int[] arr, int totalTime) {
        int sum = 0;
        int max = 0;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            if (right - left + 1 > totalTime) {
                sum -= arr[left];
                left++;
            }

            max = Math.max(max, sum);
        }

        return max;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna