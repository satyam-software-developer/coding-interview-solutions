class Solution {
    public static boolean areEqual(int a[], int b[]) {
        // code here
        // check length
        if(a.length != b.length){
            return false;
        }
        
        // Compare each element
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        
        // all elements are equal
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna