class Solution {
    public int numOfSubarrays(int[] arr) {
        long mod = 1000000007;
        long even = 1, odd = 0;
        long sum = 0;

        for (int num : arr) {
            sum += num;

            if (sum % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        return (int) (odd * even % mod);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna