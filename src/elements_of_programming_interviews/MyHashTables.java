package elements_of_programming_interviews;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyHashTables {
    /*
     * 12.6 Find the nearest repeated entries in an array
     * Input: an array of words
     * Output: Finds the distance between a closest pair of equal entries
     * Question: case sensitive? (assume yes); an array of unique words? (assume possible).
     *
     * Solution: Hash Map with word as key and the last index the word occurred at. Also have an variable that keeps
     *  the minimum distance between a pair of words.
     * Time complexity: O(n), n is the length of the words.
     * Space complexity: O(m), m is the length of the map.
     */
    public int findNearestRepeats(List<String> words) {
        int result = Integer.MAX_VALUE;
        Map<String, Integer> wordMap = new HashMap<>();

        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i).toLowerCase();

            if (wordMap.containsKey(word) && (i - wordMap.get(word) < result)) {
                result = i - wordMap.get(word);
            }

            wordMap.put(word, i);
        }

        // No duplicate word found.
        if (result > words.size()) {
            return 0;
        }

        return result;
    }
}
