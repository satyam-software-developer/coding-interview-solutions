import java.util.*;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;

            for (int start = 0; start < n && valid; start += k) {
                int[] lps = new int[k];
                int len = 0;

                for (int i = 1; i < k;) {
                    if (sorted[start + i] == sorted[start + len]) {
                        lps[i++] = ++len;
                    } else if (len > 0) {
                        len = lps[len - 1];
                    } else {
                        lps[i++] = 0;
                    }
                }

                int j = 0;
                boolean found = false;

                for (int i = 0; i < 2 * k - 1; i++) {
                    int value = nums[start + (i % k)];

                    while (j > 0 && value != sorted[start + j]) {
                        j = lps[j - 1];
                    }

                    if (value == sorted[start + j]) {
                        j++;
                    }

                    if (j == k) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    valid = false;
                }
            }

            if (valid) {
                ans += k;
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna