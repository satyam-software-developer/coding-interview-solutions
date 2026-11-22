class Solution {
	public int longestSubarrayDivK(int[] arr, int k) {
		int[] first = new int[k];
		java.util.Arrays.fill(first, -2);
		
		first[0] = -1;
		
		int sum = 0;
		int maxLen = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sum = ((sum + arr[i]) % k + k) % k;
			
			if (first[sum] != -2) {
				maxLen = Math.max(maxLen, i - first[sum]);
			} else {
				first[sum] = i;
			}
		}
		
		return maxLen;
	}
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna