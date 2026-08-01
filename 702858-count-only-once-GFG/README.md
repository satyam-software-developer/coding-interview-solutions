# [Count Only Once](https://www.geeksforgeeks.org/problems/count-only-once/1?page=1&category=Java&status=unsolved&sortBy=submissions)
## Easy
You are given an integer array arr[] of integers. You need to find how many elements exist if we count the elements only once. That is repeated elements are counted as occuring once.
Examples:
Input: arr[] = [8, 8, 6, 5, 9, 9, 2]
Output: 5
Explanation: Here 8 occurs 2 times, 6 occurs 1 time, 5 occurs 1 time, 9 occurs 2 times, and 2 occurs 1 time. So, if we account each element only once then we have 8 6 5 9 2 only. So the count is 5 here.

Input: arr[] = [7, 7, 7, 7, 7, 7, 7, 7, 7, 7]
Output: 1
Explanation: Here 7 occurs 10 times. So, if we account each element only once then we have 7 only. So the count is 1 here.
Constraints:1 &lt;= arr.size() &lt;= 1030 &lt;= arri &lt;= 107