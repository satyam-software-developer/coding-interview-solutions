import java.util.*;

class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int[] values = Arrays.stream(sorted).distinct().toArray();

        int m = values.length;
        Fenwick count = new Fenwick(m);
        Fenwick sum = new Fenwick(m);

        long[] cost = new long[n - x + 1];

        for (int i = 0; i < x; i++) {
            int idx = Arrays.binarySearch(values, nums[i]) + 1;
            count.add(idx, 1);
            sum.add(idx, nums[i]);
        }

        int medianPos = (x + 1) / 2;

        for (int i = 0; i <= n - x; i++) {
            int medianIdx = count.kth(medianPos);
            long median = values[medianIdx - 1];

            long leftCount = count.query(medianIdx);
            long leftSum = sum.query(medianIdx);

            long totalSum = sum.query(m);
            long rightCount = x - leftCount;
            long rightSum = totalSum - leftSum;

            cost[i] = median * leftCount - leftSum
                    + rightSum - median * rightCount;

            if (i < n - x) {
                int removeIdx = Arrays.binarySearch(values, nums[i]) + 1;
                int addIdx = Arrays.binarySearch(values, nums[i + x]) + 1;

                count.add(removeIdx, -1);
                sum.add(removeIdx, -nums[i]);

                count.add(addIdx, 1);
                sum.add(addIdx, nums[i + x]);
            }
        }

        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        for (int t = 1; t <= k; t++) {
            Arrays.fill(curr, INF);

            for (int i = 1; i <= n; i++) {
                curr[i] = curr[i - 1];

                if (i >= x && prev[i - x] != INF) {
                    curr[i] = Math.min(
                            curr[i],
                            prev[i - x] + cost[i - x]);
                }
            }

            long[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }

    class Fenwick {
        int n;
        long[] tree;

        Fenwick(int n) {
            this.n = n;
            tree = new long[n + 1];
        }

        void add(int i, long val) {
            while (i <= n) {
                tree[i] += val;
                i += i & -i;
            }
        }

        long query(int i) {
            long result = 0;

            while (i > 0) {
                result += tree[i];
                i -= i & -i;
            }

            return result;
        }

        int kth(long k) {
            int idx = 0;

            for (int bit = Integer.highestOneBit(n); bit > 0; bit >>= 1) {
                int next = idx + bit;

                if (next <= n && tree[next] < k) {
                    idx = next;
                    k -= tree[next];
                }
            }

            return idx + 1;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna