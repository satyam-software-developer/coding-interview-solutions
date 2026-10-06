# [Longest Increasing Path in Matrix](https://www.geeksforgeeks.org/problems/longest-increasing-path-in-a-matrix/1)
## Hard
Given a matrix with&nbsp;n&nbsp;rows and&nbsp;m&nbsp;columns, find the length of the longest path such that:The path can start and end at any cell.A cell cannot be visited more than once.The values in path are strictly increasing.&nbsp; From each cell,&nbsp; you can move left, right, up, or down. Diagonal moves and moves outside the matrix are not allowed.Examples:Input: n = 3, m = 3, matrix[][] = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
Output: 5
Explanation: One such path is 1 -&gt; 2 -&gt; 3 -&gt; 6 -&gt; 9, where each number is strictly greater than the previous.Input: n = 3, m = 3, matrix[][] = [[3, 4, 5], [6, 2, 6], [2, 2, 1]]
Output: 4
Explanation: One of the longest increasing paths is 3 -&gt; 4 -&gt; 5 -&gt; 6.Input: n = 2, m = 2, matrix[][] = [[1, 1], [1, 1]]
Output: 1
Explanation: There can at most one vertex as all vertices are same.