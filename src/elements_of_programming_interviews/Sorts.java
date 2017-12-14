package elements_of_programming_interviews;


public class Sorts {
    /*
     * 13.2 Merge two sorted arrays
     * Input: two sorted arrays of integers, integers != 0 as default value for empty entries in an int[] = 0.
     * Output: updates the first array to the combined entries of the two arrays in sorted order. Assume the first array
     *  has enough empty entries at its end to hold the result.
     *
     * Solution: Have a write index starting from the right of the first array. Then loop from right to left for each
     *  array and add the current highest number to the write index of the first array, and decrement the write index
     *  and the index of the current highest number.
     * Time complexity: O(n), n is length of first array
     * Space complexity: O(1)
     */
    public void mergeSortedArrays(int[] arrayOne, int[] arrayTwo) {
        // Find number of elements in arrayOne.
        int arrayOneIndex = 0;

        while (arrayOne[arrayOneIndex] != 0) {
            arrayOneIndex++;
        }

        arrayOneIndex--;
        int arrayTwoIndex = arrayTwo.length - 1;
        int writeIndex = arrayOneIndex + arrayTwoIndex + 1;

        // Add the highest number to the end of arrayOne.
        while (arrayOneIndex >= 0 && arrayTwoIndex >= 0) {
            if (arrayOne[arrayOneIndex] >= arrayTwo[arrayTwoIndex]) {
                arrayOne[writeIndex] = arrayOne[arrayOneIndex];
                arrayOneIndex--;
            } else {
                arrayOne[writeIndex] = arrayTwo[arrayTwoIndex];
                arrayTwoIndex--;
            }

            writeIndex--;
        }

        // Only need to add remaining numbers if arrayTwoIndex > 0.
        while (arrayTwoIndex >= 0) {
            arrayOne[writeIndex] = arrayTwo[arrayTwoIndex];
            arrayTwoIndex--;
            writeIndex--;
        }
    }
}
