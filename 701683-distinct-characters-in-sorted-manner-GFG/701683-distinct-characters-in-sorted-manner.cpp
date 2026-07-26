class Solution {
  public:
    string sortedDistinct(string &s) {
        // code here
        vector<bool> seen(26, false);

        for (char ch : s) {
            seen[ch - 'a'] = true;
        }

        string ans = "";

        for (int i = 0; i < 26; i++) {
            if (seen[i]) {
                ans += (char)(i + 'a');
            }
        }

        return ans;
        
    }
};

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna