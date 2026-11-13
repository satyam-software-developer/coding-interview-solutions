class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[] next = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int log = 17;
        int[][] up = new int[log][n];
        long[][] cost = new long[log][n];

        for (int i = 0; i < n; i++) {
            up[0][i] = next[i];
            cost[0][i] = (long) nums[i] * (next[i] - i)
                    - (prefix[next[i]] - prefix[i]);
        }

        for (int p = 1; p < log; p++) {
            for (int i = 0; i < n; i++) {
                int mid = up[p - 1][i];

                if (mid < n) {
                    up[p][i] = up[p - 1][mid];
                    cost[p][i] = cost[p - 1][i] + cost[p - 1][mid];
                } else {
                    up[p][i] = n;
                    cost[p][i] = cost[p - 1][i];
                }
            }
        }

        long ans = 0;

        for (int l = 0; l < n; l++) {
            int low = l;
            int high = n - 1;
            int best = l - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                int cur = l;
                long operations = 0;

                for (int p = log - 1; p >= 0; p--) {
                    if (up[p][cur] <= mid) {
                        operations += cost[p][cur];
                        cur = up[p][cur];
                    }
                }

                if (cur <= mid) {
                    operations += (long) nums[cur] * (mid - cur + 1)
                            - (prefix[mid + 1] - prefix[cur]);
                }

                if (operations <= k) {
                    best = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            ans += best - l + 1;
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna