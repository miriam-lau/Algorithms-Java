package elements_of_programming_interviews;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class SearchesTest {
    Searches searches;

    @Before public void initialize() {
        searches = new Searches();
    }

    @Test
    public void computeIntSquareRoot() throws Exception {
        assertEquals(17, searches.computeIntSquareRoot(300));
        assertEquals(4, searches.computeIntSquareRoot(16));
        assertEquals(2, searches.computeIntSquareRoot(4));
        assertEquals(1, searches.computeIntSquareRoot(1));
    }

    @Test
    public void findKLargestElement() throws Exception {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(3, 2, 1, 5, 4));

        assertEquals(5, searches.findKLargestElement(list1, 1));
        assertEquals(1, searches.findKLargestElement(list1, 5));
        assertEquals(3, searches.findKLargestElement(list1, 3));
    }

}