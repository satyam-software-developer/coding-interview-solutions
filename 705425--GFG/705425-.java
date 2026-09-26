class Solution {
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= x / s + 1; i++) {
            for (int j = 0; j <= x / m + 1; j++) {
                int area = i * s + j * m;
                if (area >= x) {
                    ans = Math.min(ans, i * cs + j * cm);
                } else {
                    int k = (x - area + l - 1) / l;
                    ans = Math.min(ans, i * cs + j * cm + k * cl);
                }
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna