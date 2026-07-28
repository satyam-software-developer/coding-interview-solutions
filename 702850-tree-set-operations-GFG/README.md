# [TreeSet Operations](https://www.geeksforgeeks.org/problems/treeset-operations/1?page=1&category=Java&status=unsolved&sortBy=submissions)
## Easy
You are given an integer array arr[]. You need to insert the elements of arr into a TreeSet and display the results. Also, you need to erase a given element x from the TreeSet and print "erased x" if successfully erased, else print "not found".Note: Don't add a new line in any function.
Examples:
Input: arr[] = [9, 8, 7, 4, 4, 2, 1, 1, 9, 8], x = 1
Output:
1 2 4 7 8 9
erased 1
2 4 7 8 9
Explanation: Initially TreeSet contains [1, 2, 4, 7, 8, 9]. 1 is present in the set, therefore prints "erased 1".Finally set contains [2, 4, 7, 8, 9].
Input: arr[] = [4, 2, 3, 3], x = 1Output:2 3 4not found2 3 4Explanation: Initially TreeSet contains [2, 3, 4]. 1 is not present in the set so prints "not found". Finally set remains the same.
Constraints:1 &lt;= arr.length &lt;= 10001 &lt;= arri &lt;= 106