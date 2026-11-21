import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] adj = new ArrayList[n];
        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        int[] last = new int[26];
        Arrays.fill(last, -1);

        int[] newParent = new int[n];
        int[] prev = new int[n];
        int[] index = new int[n];
        int[] stack = new int[n];

        last[s.charAt(0) - 'a'] = 0;
        newParent[0] = -1;

        int top = 0;
        stack[top] = 0;

        while (top >= 0) {
            int u = stack[top];

            if (index[u] < adj[u].size()) {
                int v = adj[u].get(index[u]++);
                int c = s.charAt(v) - 'a';

                prev[v] = last[c];
                newParent[v] = prev[v] == -1 ? parent[v] : prev[v];

                last[c] = v;
                stack[++top] = v;
            } else {
                top--;

                if (u != 0) {
                    last[s.charAt(u) - 'a'] = prev[u];
                }
            }
        }

        for (int i = 1; i < n; i++) {
            tree[newParent[i]].add(i);
        }

        int[] order = new int[n];
        top = 0;
        int size = 0;
        stack[top] = 0;

        while (top >= 0) {
            int u = stack[top--];
            order[size++] = u;

            for (int v : tree[u]) {
                stack[++top] = v;
            }
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            ans[newParent[u]] += ans[u];
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna