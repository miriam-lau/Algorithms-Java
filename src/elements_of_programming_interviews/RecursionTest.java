package elements_of_programming_interviews;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class RecursionTest {
    Recursion recursion;

    @Before public void initialize() {
        recursion = new Recursion();
    }

    @Test
    public void findGCD() throws Exception {
        assertEquals(12, recursion.findGCD(24, 36));
        assertEquals(1, recursion.findGCD(10, 11));
    }

    @Test
    public void solveTowersOfHanoi() throws Exception {
        System.out.println("3 DISCS");
        recursion.solveTowersOfHanoi(3);
        System.out.println("6 DISCS");
        recursion.solveTowersOfHanoi(6);
    }

    @Test
    public void generateQueenPlacements() throws Exception {
        List<List<Integer>> result = recursion.generateQueenPlacements(4);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}