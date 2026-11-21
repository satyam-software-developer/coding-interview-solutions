class Solution {
	public int smallestSubWithSum(int[] arr, int x) {
		int left = 0;
		int sum = 0;
		int minLen = Integer.MAX_VALUE;
		
		for (int right = 0; right < arr.length; right++) {
			sum += arr[right];
			
			while (sum > x) {
				minLen = Math.min(minLen, right - left + 1);
				sum -= arr[left++];
			}
		}
		
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna