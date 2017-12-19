package elements_of_programming_interviews;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicProgramming {
    /*
     * 16.0a Boot Camp: Compute Fibonacci numbers
     * F(n) = F(n - 1) + F(n - 2)
     * F(0) = 0 and F(1) = 1
     * Input: integer n
     * Output: return the nth Fibonacci number
     */

    /* Solution 1: Create global cache and recursively call function to populate cache.
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public Map<Integer, Integer> cache = new HashMap<>();

    public int computeNthFibNum1(int n) {
        if (n < 2) {
            return n;
        }

        // Call recursive method.
        if (!cache.containsKey(n)) {
            cache.put(n, computeNthFibNum1(n - 1) + computeNthFibNum1(n - 2));
        }

        return cache.get(n);
    }

    /*
     * Solution 2: Store the intermediate result in a variable and over-write the variable with the next result.
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int computeNthFibNum2(int n) {
        if (n < 2) {
            return n;
        }

        int fibMinusOne = 1;
        int fibMinusTwo = 0;

        for (int i = 2; i <= n; i++) {
            int temp = fibMinusOne;
            fibMinusOne += fibMinusTwo;
            fibMinusTwo = temp;
        }

        return fibMinusOne;
    }

    /*
     * 16.0b Boot Camp: Find the maximum sum over all sub-arrays
     * Input: list of integers
     * Output: return the max sum
     *
     * Example: [-10, 3, 5, 6, -2, 10], returns 22
     *
     * Solution: Loop through the array and save the max sum at i (including i) in a list. Loop through list and return
     *  the max sum in the list.
     *  For above example:
     *      list = [-10, 3, 8, 14, 12, 22]
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int findMaxSum(List<Integer> nums) {
        List<Integer> result = new ArrayList<>();
        result.add(nums.get(0));

        for (int i = 1; i < nums.size(); i++) {
            int num = nums.get(i);
            int currentMaxAndNum = num + result.get(i - 1);

            result.add((num > currentMaxAndNum) ? num : currentMaxAndNum);
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) > maxSum) {
                maxSum = result.get(i);
            }
        }

        return maxSum;
    }

    /*
     * 16.1 Count the number of score combinations
     * Input: final score and scores for individual plays
     * Output: returns the number of combinations of plays that result in the final score
     *
     * Solution:
     * Time complexity:
     * Space complexity:
     */

    /*
     * 16.2 Compute the Levenshtein distance
     * Input: two strings
     * Output: computes the minimum number of edits needed to transform the first string into the second string
     *
     * Solution:
     * Time complexity:
     * Space complexity:
     */
}
