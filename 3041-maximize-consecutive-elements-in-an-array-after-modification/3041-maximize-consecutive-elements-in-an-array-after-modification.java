import java.util.*;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        Map<Integer, Integer> dp = new HashMap<>();
        int ans = 0;

        for (int num : nums) {
            int a = dp.getOrDefault(num, 0) + 1;
            int b = dp.getOrDefault(num + 1, 0) + 1;

            dp.put(num + 1, Math.max(dp.getOrDefault(num + 1, 0), a));
            dp.put(num + 2, Math.max(dp.getOrDefault(num + 2, 0), b));

            ans = Math.max(ans, Math.max(a, b));
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna