class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int max = 0;

        for (int dr = -n + 1; dr < n; dr++) {
            for (int dc = -n + 1; dc < n; dc++) {
                int overlap = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int ni = i + dr;
                        int nj = j + dc;

                        if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                            overlap += img1[i][j] * img2[ni][nj];
                        }
                    }
                }

                max = Math.max(max, overlap);
            }
        }

        return max;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna