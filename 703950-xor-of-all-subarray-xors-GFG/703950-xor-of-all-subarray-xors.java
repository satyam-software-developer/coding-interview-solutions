class Solution {
	public int subarrayXor(int[] arr) {
		int n = arr.length;
		
		if (n % 2 == 0) {
			return 0;
		}
		
		int ans = 0;
		
		for (int i = 0; i < n; i += 2) {
			ans ^= arr[i];
		}
		
		return ans;
	}
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna