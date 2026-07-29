// Implement both the classes here

abstract class Shape {

    // Data member
    String color;

    // Constructor
    Shape(String c) {
        color = c;
    }

    // Method to return color
    public String getColor() {
        return color;
    }

    // Abstract method
    public abstract double getArea();
}

class Square extends Shape {

    // Data member
    double side;

    // Constructor
    Square(String c, double side) {
        super(c);
        this.side = side;
    }

    // Implement abstract method
    @Override
    public double getArea() {
        return side * side;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna