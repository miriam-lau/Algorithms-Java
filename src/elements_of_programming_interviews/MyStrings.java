package elements_of_programming_interviews;


public class MyStrings {
    /*
     * 6.5 Test palindromicity
     * Palindromic string: a string which when all non-alphanumeric are removed it reads the same front to back
     *  ignoring case.
     * Input: a string, s
     * Output: returns true if s is a palindromic string
     *
     * Solution: Convert string to lower case, and ignore all punctuation and case.
     * Time complexity: O(n), dominated by toLowerCase() method
     * Space complexity: O(1)
     */
    public Boolean isPalindrome(String s) {
        int leftIndex = 0;
        int rightIndex = s.length() - 1;

        while (leftIndex < rightIndex) {
            while (!Character.isLetterOrDigit(s.charAt(leftIndex))) {
                leftIndex++;
            }

            while (!Character.isLetterOrDigit(s.charAt(rightIndex))) {
                rightIndex--;
            }

            if (s.toLowerCase().charAt(leftIndex) != s.toLowerCase().charAt(rightIndex)) {
                return false;
            }

            leftIndex++;
            rightIndex--;
        }

        return true;
    }

    /*
     * 6.6 Reverse all the words in a sentence
     * Input: string containing a set of words separated by a space
     * Output: return string in which the words appear in the reverse order.
     * Do not need to keep the original string.
     *
     * Solution: Swap each char in the string.
     * Time complexity: O(n^2), dominated by reversing each word.
     * Space complexity: O(n)
     */
    public String reverseWordOrder(String str) {
        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length / 2; i++) {
            int rightIndex = charArray.length - 1 - i;
            char temp = charArray[i];
            charArray[i] = charArray[rightIndex];
            charArray[rightIndex] = temp;
        }

        // Now have a char array of reverse letters, need to reverse each word.
        int startIndex = 0;
        int endIndex = 0;

        while (endIndex < charArray.length) {
            while (charArray[endIndex] != ' ') {
                endIndex++;

                if (endIndex == charArray.length) {
                    break;
                }
            }

            // Reverse the word.
            int rightIndex = endIndex - 1;

            while (startIndex < rightIndex) {
                char temp = charArray[startIndex];
                charArray[startIndex] = charArray[rightIndex];
                charArray[rightIndex] = temp;
                startIndex++;
                rightIndex--;
            }

            // Get start index of new word.
            startIndex = endIndex + 1;
            endIndex = startIndex;
        }

        // Join the charArray and return.
        return (String.valueOf(charArray));

    }
}
