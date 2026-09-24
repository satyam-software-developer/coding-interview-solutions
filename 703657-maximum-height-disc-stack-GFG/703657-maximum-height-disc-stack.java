class Solution {
    public int maxStackHeight(int[] r, int[] h) {
        int n = r.length;
        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            a[i][0] = r[i];
            a[i][1] = h[i];
        }

        java.util.Arrays.sort(a, (x, y) -> {
            if (x[0] != y[0]) return Integer.compare(x[0], y[0]);
            return Integer.compare(x[1], y[1]);
        });

        int[] bit = new int[1002];
        int ans = 0;

        int i = 0;
        while (i < n) {
            int j = i;

            while (j < n && a[j][0] == a[i][0]) {
                j++;
            }

            int[] dp = new int[j - i];

            for (int p = i; p < j; p++) {
                int height = a[p][1];
                dp[p - i] = query(bit, height - 1) + height;
                ans = Math.max(ans, dp[p - i]);
            }

            for (int p = i; p < j; p++) {
                update(bit, a[p][1], dp[p - i]);
            }

            i = j;
        }

        return ans;
    }

    private int query(int[] bit, int index) {
        int res = 0;
        while (index > 0) {
            res = Math.max(res, bit[index]);
            index -= index & -index;
        }
        return res;
    }

    private void update(int[] bit, int index, int value) {
        while (index < bit.length) {
            bit[index] = Math.max(bit[index], value);
            index += index & -index;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna