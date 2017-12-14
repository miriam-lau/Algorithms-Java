package elements_of_programming_interviews;


import java.util.List;

public class Searches {
    /*
     * 11.4 Compute the integer square root
     * Input: non-negative integer
     * Output: returns the largest integer whose square is <= to the given integer.
     *
     * Solution: The square of the largest int <= to any given number will always be <= half the number. Set the high
     *  number to number / 2, and use binary search.
     * Time complexity: O(logn) binary search
     * Space complexity: O(1)
     */
    public int computeIntSquareRoot(int num) {
        // Edge case.
        if (num < 2) {
            return num;
        }

        int low = 2;
        int high = (int)Math.floor(num / 2);
        int result = -1;

        // If mid squared == num, then return mid. If mid squared is less than num, need to save mid in case mid + 1 is
        // greater than num.
        while (low <= high) {
            int mid = (int)Math.floor((high - low) / 2) + low;
            int midSquared = mid * mid;

            if (midSquared == num) {
                return mid;
            } else if (midSquared > num) {
                high = mid - 1;
            } else {
                result = mid;
                low = mid + 1;
            }
        }

        return result;
    }

    /*
     * 11.8 Find the kth largest element
     * The first largest element is the largest element. The nth (n is the length of the array) largest element is the
     *  smallest element.
     * Design an algorithm for computing the kth largest element in an array.
     * Assume entries are distinct and array is not sorted.
     *
     * Input: array of integers
     * Output: return the kth largest element
     * Example: A = [3, 2, 1, 5, 4], A[3] is the first largest element and A[0] is the third largest element
     *
     * Solution: Need to either sort the array or store k elements in a heap. Time complexity would be O(n) at best
     *  because will need to look at each element in the array once. For space, a heap would be O(k) and at worst case
     *  it would O(n) where k is the length of the array. If can sort the array itself, then space is reduced to O(1).
     *  Sort array using a partition index set to k.
     * Time complexity: O(n*logn)
     * Space complexity: O(1)
     */
    public int findKLargestElement(List<Integer> list, int k) {
        // Sort on a pivot.
        int pivotIndex = list.size() - 1;
        int leftIndex = 0;
        int partitionIndex = leftIndex;

        while (true) {
            int pivot = list.get(pivotIndex);

            while (leftIndex < pivotIndex) {
                if (list.get(leftIndex) > pivot) {
                    int temp = list.get(leftIndex);
                    list.set(leftIndex, list.get(partitionIndex));
                    list.set(partitionIndex, temp);
                    partitionIndex++;
                }

                leftIndex++;
            }

            // Swap elements at partitionIndex and pivotIndex.
            int temp = list.get(partitionIndex);
            list.set(partitionIndex, pivot);
            list.set(pivotIndex, temp);

            // Set the new left and pivot index.
            if (partitionIndex == k - 1) {
                return list.get(partitionIndex);
            } else if (partitionIndex > k - 1) {
                pivotIndex = partitionIndex - 1;
                leftIndex = 0;
                partitionIndex = leftIndex;
            } else {
                leftIndex = partitionIndex + 1;
                partitionIndex = leftIndex;
            }
        }
    }
}
