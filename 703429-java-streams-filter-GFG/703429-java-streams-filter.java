class Solution {
    public static int filterUsingStreams(int[] arr) {
        // code here
          return Arrays.stream(arr)
                     .filter(num -> num % 2 != 0)
                     .max()
                     .getAsInt();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna