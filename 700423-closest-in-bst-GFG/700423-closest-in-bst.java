/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left, right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int minDiff(Node root, int k) {
        int min = Integer.MAX_VALUE;

        while (root != null) {
            min = Math.min(min, Math.abs(root.data - k));

            if (root.data == k) {
                return 0;
            } else if (k < root.data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return min;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna