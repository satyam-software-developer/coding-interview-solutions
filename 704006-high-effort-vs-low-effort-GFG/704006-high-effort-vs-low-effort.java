class Solution {
    public int maxTask(int[] h, int[] l) {
        int noTask = 0;
        int task = 0;

        for (int i = 0; i < h.length; i++) {
            int newNoTask = Math.max(noTask, task);
            int newTask = Math.max(noTask + h[i], Math.max(noTask, task) + l[i]);

            noTask = newNoTask;
            task = newTask;
        }

        return Math.max(noTask, task);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna