class Solution {
    int k;
    int[][] pref;
    int[] prod;
    int n;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        this.n = nums.length;
        pref = new int[4 * n][k];
        prod = new int[4 * n];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            update(1, 0, n - 1, index, value % k);

            Node res = query(1, 0, n - 1, start, n - 1);
            ans[q] = res.pref[x];
        }

        return ans;
    }

    void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            int v = nums[l] % k;
            prod[node] = v;
            pref[node][v] = 1;
            return;
        }

        int mid = (l + r) >>> 1;
        build(node << 1, l, mid, nums);
        build(node << 1 | 1, mid + 1, r, nums);
        merge(node);
    }

    void update(int node, int l, int r, int idx, int value) {
        if (l == r) {
            java.util.Arrays.fill(pref[node], 0);
            prod[node] = value;
            pref[node][value] = 1;
            return;
        }

        int mid = (l + r) >>> 1;
        if (idx <= mid) {
            update(node << 1, l, mid, idx, value);
        } else {
            update(node << 1 | 1, mid + 1, r, idx, value);
        }

        merge(node);
    }

    void merge(int node) {
        int left = node << 1;
        int right = left | 1;

        java.util.Arrays.fill(pref[node], 0);

        for (int i = 0; i < k; i++) {
            pref[node][i] += pref[left][i];
        }

        for (int r = 0; r < k; r++) {
            int residue = (prod[left] * r) % k;
            pref[node][residue] += pref[right][r];
        }

        prod[node] = (prod[left] * prod[right]) % k;
    }

    Node query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return new Node(pref[node], prod[node], k);
        }

        int mid = (l + r) >>> 1;

        if (qr <= mid) {
            return query(node << 1, l, mid, ql, qr);
        }

        if (ql > mid) {
            return query(node << 1 | 1, mid + 1, r, ql, qr);
        }

        Node a = query(node << 1, l, mid, ql, qr);
        Node b = query(node << 1 | 1, mid + 1, r, ql, qr);

        return mergeNodes(a, b);
    }

    Node mergeNodes(Node a, Node b) {
        int[] p = new int[k];

        for (int i = 0; i < k; i++) {
            p[i] += a.pref[i];
        }

        for (int i = 0; i < k; i++) {
            int residue = (a.prod * i) % k;
            p[residue] += b.pref[i];
        }

        int totalProd = (a.prod * b.prod) % k;

        return new Node(p, totalProd, k);
    }

    static class Node {
        int[] pref;
        int prod;

        Node(int[] pref, int prod, int k) {
            this.pref = java.util.Arrays.copyOf(pref, k);
            this.prod = prod;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna