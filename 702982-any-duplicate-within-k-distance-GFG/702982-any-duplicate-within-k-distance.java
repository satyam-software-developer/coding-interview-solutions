class Solution {
	public boolean checkWithinK(int[] arr, int k) {
		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i])) {
				return true;
			}
			
			set.add(arr[i]);
			
			if (i >= k) {
				set.remove(arr[i - k]);
			}
		}
		
		return false;
	}
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna