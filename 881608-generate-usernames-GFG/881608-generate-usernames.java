import java.util.*;

class Solution {
	public ArrayList<String> generateUsernames(String[] arr) {
		HashSet<String> reserved = new HashSet<>();
		HashMap<String, Integer> next = new HashMap<>();
		ArrayList<String> result = new ArrayList<>();
		
		for (String s : arr) {
			reserved.add(s);
		}
		
		for (String s : arr) {
			if (!next.containsKey(s)) {
				result.add(s);
				next.put(s, 1);
			} else {
				int num = next.get(s);
				
				while (reserved.contains(s + num)) {
					num++;
				}
				
				String username = s + num;
				result.add(username);
				reserved.add(username);
				next.put(s, num + 1);
			}
		}
		
		return result;
	}
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna