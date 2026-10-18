class Solution {
    public int minimumStep(int n) {
        int steps = 0;

        while (n > 1) {
            if (n % 3 == 0) {
                n /= 3;
            } else {
                n--;
            }
            steps++;
        }

        return steps;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna