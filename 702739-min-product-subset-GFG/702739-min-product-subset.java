class Solution {
    public int minProd(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];

            int a = min * x;
            int b = max * x;

            int newMin = Math.min(x, Math.min(a, b));
            int newMax = Math.max(x, Math.max(a, b));

            min = Math.min(min, newMin);
            max = Math.max(max, newMax);
        }

        return min;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna