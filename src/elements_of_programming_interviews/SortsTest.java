package elements_of_programming_interviews;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class SortsTest {
    Sorts mySort;

    @Before public void initialize() {
        mySort = new Sorts();
    }

    @Test
    public void mergeSortedArrays() throws Exception {
        int[] one = new int[8];
        one[0] = 5;
        one[1]= 13;
        one[2] = 17;
        int[] two = new int[]{3, 7, 11, 19};
        int[] result1 = new int[]{3, 5, 7, 11, 13, 17, 19, 0};

        int[] three = new int[8];
        three[0] = 5;
        three[1]= 13;
        three[2] = 17;
        int[] four = new int[0];
        int[] result2 = new int[]{5, 13, 17, 0, 0, 0, 0, 0};

        mySort.mergeSortedArrays(one, two);
        mySort.mergeSortedArrays(three, four);

        assertArrayEquals(result1, one);
        assertArrayEquals(result2, three);
    }

}