class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int num : nums1) {
            if (num % 2 == 0) {
                minEven = Math.min(minEven, num);
            } else {
                minOdd = Math.min(minOdd, num);
            }
        }

        boolean canMakeOdd = true;
        boolean canMakeEven = true;

        for (int num : nums1) {
            boolean odd = num % 2 != 0;
            boolean canOdd = odd;
            boolean canEven = !odd;

            if (minOdd < num) {
                if (odd) {
                    canEven = true;
                } else {
                    canOdd = true;
                }
            }

            if (minEven < num) {
                if (odd) {
                    canOdd = true;
                } else {
                    canEven = true;
                }
            }

            if (!canOdd) {
                canMakeOdd = false;
            }

            if (!canEven) {
                canMakeEven = false;
            }
        }

        return canMakeOdd || canMakeEven;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna