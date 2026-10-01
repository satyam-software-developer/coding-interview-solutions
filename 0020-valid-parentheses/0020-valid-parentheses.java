class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack[++top] = c;
            } else {
                if (top == -1)
                    return false;

                char open = stack[top--];

                if ((c == ')' && open != '(') ||
                        (c == ']' && open != '[') ||
                        (c == '}' && open != '{')) {
                    return false;
                }
            }
        }

        return top == -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna