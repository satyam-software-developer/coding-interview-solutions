class Solution {
    public ArrayList<Integer> queueTraversal(Queue<Integer> q) {
        // code here
        ArrayList<Integer> ans =  new ArrayList<>();
        
        while(!q.isEmpty()){
            ans.add(q.poll());
        }
        return ans;
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna