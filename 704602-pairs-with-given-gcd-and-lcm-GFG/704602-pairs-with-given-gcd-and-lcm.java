class Solution {
    public int pairCount(int x, int y) {
        if (y % x != 0) {
            return 0;
        }

        int n = y / x;
        int count = 0;

        for (int a = 1; a <= n; a++) {
            if (n % a == 0 && gcd(a, n / a) == 1) {
                count++;
            }
        }

        return count;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna