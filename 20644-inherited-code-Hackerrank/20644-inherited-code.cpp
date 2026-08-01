

/* Define the exception here */
class BadLengthException : public exception {
    int len;

public:
    BadLengthException(int n) {
        len = n;
    }

    string what() {
        return to_string(len);
    }
};



// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna