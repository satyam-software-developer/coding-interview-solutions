class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                int i = sb.length() - 1;
                while (i >= 0 && sb.charAt(i) != '(') {
                    i--;
                }

                StringBuilder temp = new StringBuilder(sb.substring(i + 1));
                temp.reverse();

                sb.delete(i, sb.length());
                sb.append(temp);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna