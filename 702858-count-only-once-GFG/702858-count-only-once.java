class Solution {
    public static int countOnce(int arr[]) {
        // Your code here
        HashSet<Integer> set =  new HashSet<>();
        
        for(int num : arr){
            
            set.add(num);
        }
        
        return set.size();
        
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna