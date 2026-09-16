# [Dominant Pairs](https://www.geeksforgeeks.org/problems/dominant-pairs/1)
## Easy
Given an even-sized integer array arr[], count the number of dominant pairs. A pair of indices (i, j) is called dominant if all of the following conditions hold:0 ≤ i &lt; arr.size() / 2arr.size() / 2 ≤ j &lt; arr.size()&nbsp;arr[i] ≥ 5 × arr[j]&nbsp;Return the total number of dominant pairs. Note: 0-based indexing is used.Examples:Input: arr[] = [10, 2, 2, 1]
Output: 2
Explanation: First half: [10, 2], Second half: [2, 1]. So valid two pairs are: {0, 2}: 10 &gt;= 5 × 2 {0, 3}: 10 &gt;= 5 × 1 Input: arr[] = [10, 8, 2, 1, 1, 2]
Output: 5
Explanation: First half: [10, 8, 2], Second half: [1, 1, 2]. So valid five pairs are: {0, 3}: 10 &gt;= 5 × 1{0, 4}: 10 &gt;= 5 × 1 {0, 5}: 10 &gt;= 5 × 2{1, 3}: 8 &gt;= 5 × 1 {1, 4}: 8 &gt;= 5 × 1 