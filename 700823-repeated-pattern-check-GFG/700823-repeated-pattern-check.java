class Solution {
	public boolean findPattern(String s) {
		int i = 0;
		int n = s.length();
		
		while (i < n) {
			if (s.charAt(i) != 'x') {
				return false;
			}
			
			int x = 0;
			while (i < n && s.charAt(i) == 'x') {
				x++;
				i++;
			}
			
			int y = 0;
			while (i < n && s.charAt(i) == 'y') {
				y++;
				i++;
			}
			
			if (x == 0 || x != y) {
				return false;
			}
		}
		
		return true;
	}
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna