class Solution {
  public int countEdges(ArrayList<ArrayList<Integer>> adj) {
    int count = 0;

    for (int i = 0; i < adj.size(); i++) {
      count += adj.get(i).size();
    }

    return count / 2;
  }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna