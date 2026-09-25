import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        int[] i = { 0 };
        Set<String> set = parse(expression, i);
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    private Set<String> parse(String s, int[] i) {
        Set<String> res = new HashSet<>();
        res.add("");

        while (i[0] < s.length() && s.charAt(i[0]) != '}' && s.charAt(i[0]) != ',') {
            Set<String> cur;

            if (s.charAt(i[0]) == '{') {
                i[0]++;
                cur = new HashSet<>();

                while (true) {
                    cur.addAll(parse(s, i));

                    if (s.charAt(i[0]) == ',') {
                        i[0]++;
                    } else {
                        i[0]++;
                        break;
                    }
                }
            } else {
                cur = new HashSet<>();
                cur.add(String.valueOf(s.charAt(i[0]++)));
            }

            Set<String> next = new HashSet<>();
            for (String a : res) {
                for (String b : cur) {
                    next.add(a + b);
                }
            }
            res = next;
        }

        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna