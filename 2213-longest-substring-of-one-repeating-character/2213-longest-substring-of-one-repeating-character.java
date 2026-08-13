class Solution {
    int[] lc, rc, mx, pre, suf;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();

        lc = new int[4 * n];
        rc = new int[4 * n];
        mx = new int[4 * n];
        pre = new int[4 * n];
        suf = new int[4 * n];

        char[] arr = s.toCharArray();

        build(1, 0, n - 1, arr);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {
            int pos = queryIndices[i];
            arr[pos] = queryCharacters.charAt(i);

            update(1, 0, n - 1, pos, arr[pos]);

            ans[i] = mx[1];
        }

        return ans;
    }

    void build(int node, int l, int r, char[] arr) {
        if (l == r) {
            lc[node] = rc[node] = arr[l];
            mx[node] = pre[node] = suf[node] = 1;
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid, arr);
        build(node * 2 + 1, mid + 1, r, arr);

        merge(node, mid - l + 1, r - mid);
    }

    void update(int node, int l, int r, int pos, char ch) {
        if (l == r) {
            lc[node] = rc[node] = ch;
            mx[node] = pre[node] = suf[node] = 1;
            return;
        }

        int mid = (l + r) / 2;

        if (pos <= mid) {
            update(node * 2, l, mid, pos, ch);
        } else {
            update(node * 2 + 1, mid + 1, r, pos, ch);
        }

        merge(node, mid - l + 1, r - mid);
    }

    void merge(int node, int leftSize, int rightSize) {
        int a = node * 2;
        int b = node * 2 + 1;

        lc[node] = lc[a];
        rc[node] = rc[b];

        pre[node] = pre[a];
        suf[node] = suf[b];

        mx[node] = Math.max(mx[a], mx[b]);

        if (rc[a] == lc[b]) {
            mx[node] = Math.max(mx[node], suf[a] + pre[b]);

            if (pre[a] == leftSize) {
                pre[node] = leftSize + pre[b];
            }

            if (suf[b] == rightSize) {
                suf[node] = rightSize + suf[a];
            }
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna