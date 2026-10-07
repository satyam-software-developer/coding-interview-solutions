import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();

        int left = 0, right = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0)
                    left--;
                else
                    right++;
            }
        }

        backtrack(s, 0, 0, left, right, new StringBuilder(), set);

        return new ArrayList<>(set);
    }

    private void backtrack(String s, int index, int balance,
            int leftRemove, int rightRemove,
            StringBuilder path, Set<String> set) {

        if (index == s.length()) {
            if (balance == 0 && leftRemove == 0 && rightRemove == 0) {
                set.add(path.toString());
            }
            return;
        }

        char c = s.charAt(index);

        if (c == '(') {
            if (leftRemove > 0) {
                backtrack(s, index + 1, balance,
                        leftRemove - 1, rightRemove, path, set);
            }

            path.append(c);
            backtrack(s, index + 1, balance + 1,
                    leftRemove, rightRemove, path, set);
            path.deleteCharAt(path.length() - 1);

        } else if (c == ')') {
            if (rightRemove > 0) {
                backtrack(s, index + 1, balance,
                        leftRemove, rightRemove - 1, path, set);
            }

            if (balance > 0) {
                path.append(c);
                backtrack(s, index + 1, balance - 1,
                        leftRemove, rightRemove, path, set);
                path.deleteCharAt(path.length() - 1);
            }

        } else {
            path.append(c);
            backtrack(s, index + 1, balance,
                    leftRemove, rightRemove, path, set);
            path.deleteCharAt(path.length() - 1);
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna