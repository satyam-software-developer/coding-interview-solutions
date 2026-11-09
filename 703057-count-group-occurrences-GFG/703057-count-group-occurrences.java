class Solution {
	int getCount(String s, int k) {
		int[] count = new int[26];
		
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
				count[s.charAt(i) - 'a']++;
			}
		}
		
		int ans = 0;
		
		for (int i = 0; i < 26; i++) {
			if (count[i] == k) {
				ans++;
			}
		}
		
		return ans;
	}
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna