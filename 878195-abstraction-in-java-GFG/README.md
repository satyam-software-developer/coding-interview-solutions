# [Abstraction in Java](https://www.geeksforgeeks.org/problems/abstraction-in-java/1?page=1&category=Java&status=unsolved&sortBy=submissions)
## Easy
Implement the following classes to understand abstraction in Java :Note: Driver code makes all the function calls and print statements
Name: Shape (Abstract)Data member/Attributes: color (String)Constructor: Shape(String c) -&gt; assign value of c to colorMethods/Functions: getColor() -&gt; returns value of color                   getArea() -&gt; abstract function with double return type
Name: Square (extends Shape)Data member/Attributes: side (double)Constructor: Square(String c, double side) -&gt; calls super(c) function and assign value to side.Method/Function: getArea() -&gt; returns area of square
Example:
Input: color = "red", side = 5.0Output: red 25.0red 25.0