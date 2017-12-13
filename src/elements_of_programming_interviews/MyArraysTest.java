package elements_of_programming_interviews;

import org.junit.Before;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MyArraysTest {
    MyArrays myArrays;

    @Before public void initialize() {
        myArrays = new MyArrays();
    }

    @org.junit.Test
    // James: Return random subsets 
    // James: Actually returning random subsets is not testable. You can only ensure the size of the returned
    // array is correct.
    public void evenFirst() throws Exception {
        ArrayList<Integer> ints1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        // James: Just pass size directly into the function instead of having a variable that's only used once.
        int size = 5;
        ArrayList<Integer> copyInt1 = new ArrayList<>(ints1);
        myArrays.evenFirst(ints1, size);

        assertFalse(ints1.equals(copyInt1));

        ArrayList<Integer> ints2 = new ArrayList<>(Arrays.asList(1));
        // James: Just pass size directly into the function.
        size = 1;
        ArrayList<Integer> copyInt2 = new ArrayList<>(ints2);
        myArrays.evenFirst(ints2, size);

        assertTrue(ints2.equals(copyInt2));
    }

    @org.junit.Test
    public void computeSpiralOrdering() throws Exception {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        matrix.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        matrix.add(new ArrayList<>(Arrays.asList(7, 8, 9)));
        List<Integer> result = new ArrayList<>(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5));

        // James: Expected value should come before actual.
        assertEquals(myArrays.computeSpiralOrdering(matrix), result);
    }
}
