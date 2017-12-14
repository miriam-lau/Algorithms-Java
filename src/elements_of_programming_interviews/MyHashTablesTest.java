package elements_of_programming_interviews;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class MyHashTablesTest {
    MyHashTables map;

    @Before public void initialize() {
        map = new MyHashTables();
    }

    @Test
    public void findNearestRepeats() throws Exception {
        List<String> words1 = new ArrayList<>(Arrays.asList("All", "work", "and", "no", "play", "makes", "for", "no",
                "work", "no", "fun", "and", "no", "results"));
        List<String> words2 = new ArrayList<>(Arrays.asList("I", "once", "saw", "John", "kill", "two", "men", "with",
                "a", "pencil"));
        List<String> words3 = new ArrayList<>(Arrays.asList(""));

        assertEquals(2, map.findNearestRepeats(words1));
        assertEquals(0, map.findNearestRepeats(words2));
        assertEquals(0, map.findNearestRepeats(words3));
    }
}