package elements_of_programming_interviews;

import java.util.ArrayList;
import java.util.List;


public class MyArrays {
    /*
     * 5.12 Sample offline data
     * Input: an array of distinct elements and a size
     * Output: returns a subset of the given size of the array elements.
     * All subsets should be equally likely. Return the result in the input array itself.
     *
     * Solution: will need a randomly swap all elements up to size each time.
     * Time complexity: O(m), where m is the size, worst case is m = n (size of the array itself).
     * Space complexity: O(1)
     */
    public void evenFirst(ArrayList<Integer> ints, int size) {
        if (size > ints.size() || size < 0) {
            throw new IllegalArgumentException("Size is out of bounds");
        }

        for (int i = 0; i < size; i++) {
            int swapIndex = (int)(Math.random() * (((ints.size() - 1) - i) + 1) + i);
            int temp = ints.get(i);
            ints.set(i, ints.get(swapIndex));
            ints.set(swapIndex, temp);
        }
    }

    /*
     * 5.18 Compute the spiral ordering of a 2D array
     * Input: n x n 2D array
     * Output: returns the spiral ordering of the array.
     *
     * Example: input = [ [1, 2, 3], [4, 5, 6], [7, 8, 9] ], returns [1, 2, 3, 6, 9, 8, 7, 4, 5]
     *
     * Solution: will need a variable to keep track of direction to traverse, i.e. left, right, down, up
     * Time complexity: O(n^2), need to go to each element in the nested list
     * Space complexity: O(n)
     */
    public List<Integer> computeSpiralOrdering(List<List<Integer>> matrix) {
        String direction = "right";
        int verticalIndex = 0;
        int verticalOffset = 0;
        int horizontalIndex = 0;
        int horizontalOffset = 0;
        List<Integer> result = new ArrayList<>();

        while (result.size() < (matrix.size() * matrix.size())) {
            result.add(matrix.get(verticalIndex).get(horizontalIndex));

            if (direction == "right") {
                if (horizontalIndex == (matrix.size() - 1) - horizontalOffset) {
                    direction = "down";
                    verticalIndex++;
                } else {
                    horizontalIndex++;
                }
            } else if (direction == "down") {
                if (verticalIndex == (matrix.size() - 1) - verticalOffset) {
                    direction = "left";
                    horizontalIndex--;
                } else {
                    verticalIndex++;
                }
            } else if (direction == "left") {
                if (horizontalIndex == horizontalOffset) {
                    direction = "up";
                    verticalIndex--;
                    verticalOffset++;
                } else {
                    horizontalIndex--;
                }
            } else {
                if (verticalIndex == verticalOffset) {
                    direction = "right";
                    horizontalIndex++;
                    horizontalOffset++;
                } else {
                    verticalIndex--;
                }
            }
        }

        return result;
    }
}



