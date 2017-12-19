package elements_of_programming_interviews;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Recursion {
    /*
     * 15.0 Boot Camp: Find GCD
     * Calculate the GCD of two numbers
     * Input: two integers
     * Output: GCD
     *
     * Solution: The GCD of the smallest number that the larger number is divisible by.
     * Time complexity: O(n) worst case, where n is the smallest number
     * Space complexity: O(n) worst case, where n is the smallest number
     */
    public int findGCD(int a, int b) {
        int largerNum = (a <= b ? b : a);
        int smallerNum = (a <= b ? a : b);

        return findGCDHelper(smallerNum, 1, largerNum);
    }

    public int findGCDHelper(int smallerNum, int factor, int largerNum) {
        if (largerNum % (smallerNum / factor) == 0) {
            return (smallerNum / factor);
        }

        factor++;

        if (smallerNum % factor != 0) {
            factor++;
        }

        return findGCDHelper(smallerNum, factor, largerNum);
    }

    /*
     * 15.0 Boot Camp: Compute a placement of triominoes
     * Design an algorithm that computes a placement of 21 triominoes that covers the 8 x 8 Mboard (M = mutilated,
     *  which means is made up of 64 unit-sized squares minus the top-left square). A valid placement cannot have
     *  overlapping triominoes or triominoes which extend out of the board.
     *
     * Solution: Use Divide-and-Conquer Recursive algorithm
     * Time complexity:
     * Space complexity:
     */


    /*
     * 15.1 The Towers of Hanoi problem // Need help
     * Input: n
     * Output: prints a sequence of operations that transfers n rings from one peg to another. You have a third peg
     *  which is initially empty.
     *
     * Solution: Need to create a list to hold 3 stacks representing each peg column. Also need to have a helper
     *  recursive function to print out steps.
     *  - Move (n - 1) discs to intermediate peg using final peg.
     *  - Move last disc to final peg.
     *  - Move (n - 1) discs from intermediate peg to final peg using start peg.
     * Time complexity:
     * Space complexity:
     */
    public void solveTowersOfHanoi(int n) {
        List<Deque<Integer>> pegColumns = new ArrayList<>();

        // Create columns.
        for (int i = 0; i < 3; i++) {
            pegColumns.add(new ArrayDeque<>());
        }

        // Add pegs.
        for (int i = n; i > 0; i--) {
            pegColumns.get(0).addFirst(i);
        }

        // Recursively call function to print steps.
        printTowersOfHanoiSteps(pegColumns, n, 0, 1, 2);
    }

    public void printTowersOfHanoiSteps(
            List<Deque<Integer>> pegColumns, int n, int fromPegColumn, int toPegColumn, int usePegColumn) {
        // Base case
        if (n > 0) {
            printTowersOfHanoiSteps(pegColumns, n - 1, fromPegColumn, usePegColumn, toPegColumn);
            // Get peg to move.
            int pegToMove = pegColumns.get(fromPegColumn).removeFirst();
            pegColumns.get(toPegColumn).addFirst(pegToMove);

            System.out.println("Move disc " + pegToMove + " from peg " + fromPegColumn + " to peg " + toPegColumn);

            printTowersOfHanoiSteps(pegColumns, n - 1, usePegColumn, toPegColumn, fromPegColumn);
        }
    }

    /*
     * 15.2 Generate all non-attacking placements of n-Queens
     * Non-attacking placements: No two queens are in the same row, column or diagonal
     * Input: n
     * Output: return all distinct non-attacking placements of n queens on an n x n chessboard.
     *
     * Time complexity: O(n), n is non-attacking placements of queens
     * Space complexity:
     */
    public List<List<Integer>> generateQueenPlacements(int n) {
        List<List<Integer>> result = new ArrayList<>();

        solveNQueens(n, 0, new ArrayList<>(), result);

        return result;
    }

    public void solveNQueens(int n, int row, List<Integer> queenPlacement, List<List<Integer>> result) {
        if (n == row) {
            // Base case: All queens are legally placed, add placement to result.
            result.add(new ArrayList<>(queenPlacement));
        } else {
            // Add a queen on a column and then check if the queen is a valid placement.
            for (int i = 0; i < n; i++) {
                queenPlacement.add(i);

                if (isValidPlacement(queenPlacement)) {
                    solveNQueens(n, row + 1, queenPlacement, result);
                }

                // Whether it is a valid placement or not, need to remove the added queen. Why?
                queenPlacement.remove(queenPlacement.size() - 1);
            }
        }
    }

    public Boolean isValidPlacement(List<Integer> queenPlacement) {
        int rowOfLastQueenPlaced = queenPlacement.size() - 1;
        int columnOfLastQueenPlaced = queenPlacement.get(rowOfLastQueenPlaced);

        for (int row = 0; row < rowOfLastQueenPlaced; row++) {
            int column = queenPlacement.get(row);

            // Check column and diagonals. Do not need to check row as row is always less than the last row.
            if ((columnOfLastQueenPlaced == column) ||
                    (Math.abs(rowOfLastQueenPlaced - row) - Math.abs(columnOfLastQueenPlaced - column) == 0)) {
                return false;
            }
        }

        return true;
    }
}
