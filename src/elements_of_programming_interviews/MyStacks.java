package elements_of_programming_interviews;


import java.util.ArrayDeque;
import java.util.Deque;

public class MyStacks {
    /*
     * 8.2 Evaluate RPN expressions
     * A string is an arithmetical expression in Reverse Polish Notation (RPN) if:
     *  1) It is a single digit or a sequence of digits, prefixed witha n option -, e.g. "6", "123", "-42".
     *  2) It is of the form "A, B, symb" where A and B are RPN expressions and sym is +, -, x, or /.
     * Examples of RPN expressions: "1729", "3, 4, +, 2, x, 1, +", "1, 1, +, -2, x"
     *
     * Input: an arithmetical expression in RPN
     * Output: returns the number that the expression evaluates to
     *
     * Solution: The string can be broken up to smaller RPN expressions and needs to be evaluated from left to right.
     * Time complexity: O(n)
     * Space complexity: O(n), n is the length of the strArray
     */
    public int evaluateRPNExpression(String str) {
        if (str.length() == 0) {
            return 0;
        }

        String[] strArray = str.split(",");
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].equals("+") || strArray[i].equals("-") || strArray[i].equals("x") ||
                    strArray[i].equals("/")) {
                int second = stack.removeFirst();
                int first = stack.removeFirst();

                switch (strArray[i]) {
                    case "+":
                        stack.addFirst(first + second);
                        break;
                    case "-":
                        stack.addFirst(first - second);
                        break;
                    case "x":
                        stack.addFirst(first * second);
                        break;
                    case "/":
                        stack.addFirst(first / second);
                        break;
                }
            } else {
                stack.addFirst(Integer.parseInt(strArray[i]));
            }
        }

        return stack.peekFirst();
    }
}
