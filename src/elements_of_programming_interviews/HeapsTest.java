package elements_of_programming_interviews;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class HeapsTest {
    Heaps heap;

    @Before public void intialize() {
        heap = new Heaps();
    }

    @Test
    public void findKClosestStars() throws Exception {
        List<Integer> coordsA = new ArrayList<>(Arrays.asList(1, 1, 1));
        List<Integer> coordsB = new ArrayList<>(Arrays.asList(2, 1, 1));
        List<Integer> coordsC = new ArrayList<>(Arrays.asList(6, 6, 6));

        Star A = new Star(coordsA); // distance = 1;
        Star B = new Star(coordsB); // distance = 2;
        Star C = new Star(coordsC); // distance = 216;

        List<Star> stars = new ArrayList<>(Arrays.asList(A, B, C));

        Star[] result1 = new Star[]{A, B, C};
        Object[] heapResult1 = heap.findKClosestStars(stars, 5);

        assertEquals(result1.length, heapResult1.length);

        for (Object obj : heapResult1) {
            assertTrue(Arrays.asList(result1).contains(obj));
        }

        List<Integer> coordsD = new ArrayList<>(Arrays.asList(2, 2, 2));
        List<Integer> coordsE = new ArrayList<>(Arrays.asList(3, 1, 1));
        List<Integer> coordsF = new ArrayList<>(Arrays.asList(3, 2, 1));
        List<Integer> coordsG = new ArrayList<>(Arrays.asList(3, 3, 1));
        List<Integer> coordsH = new ArrayList<>(Arrays.asList(3, 3, 2));
        List<Integer> coordsI = new ArrayList<>(Arrays.asList(3, 3, 3));
        List<Integer> coordsJ = new ArrayList<>(Arrays.asList(4, 3, 1));
        List<Integer> coordsK = new ArrayList<>(Arrays.asList(4, 2, 4));
        List<Integer> coordsL = new ArrayList<>(Arrays.asList(5, 5, 5));
        List<Integer> coordsM = new ArrayList<>(Arrays.asList(2, 2, 1));

        Star D = new Star(coordsD); // distance = 8;
        Star E = new Star(coordsE); // distance = 3;
        Star F = new Star(coordsF); // distance = 6;
        Star G = new Star(coordsG); // distance = 9;
        Star H = new Star(coordsH); // distance = 18;
        Star I = new Star(coordsI); // distance = 27;
        Star J = new Star(coordsJ); // distance = 12;
        Star K = new Star(coordsK); // distance = 32;
        Star L = new Star(coordsL); // distance = 125;
        Star M = new Star(coordsM); // distance = 4;

        stars.add(D);
        stars.add(E);
        stars.add(F);
        stars.add(G);
        stars.add(H);
        stars.add(I);
        stars.add(J);
        stars.add(K);
        stars.add(L);
        stars.add(M);

        Star[] result2 = new Star[]{A, B, E, M, F};
        Object[] heapResult2 = heap.findKClosestStars(stars, 5);

        assertEquals(result2.length, heapResult2.length);

        for (Object obj : heapResult2) {
            assertTrue(Arrays.asList(result2).contains(obj));
        }

        List<Integer> coordsN = new ArrayList<>(Arrays.asList(2, 1, 1));
        List<Integer> coordsO = new ArrayList<>(Arrays.asList(3, 3, 3));

        Star N = new Star(coordsN); // distance = 2;
        Star O = new Star(coordsO); // distance = 9;

        stars.add(N);
        stars.add(O);

        Star[] result3 = new Star[]{A, B, E, M, N};
        Object[] heapResult3 = heap.findKClosestStars(stars, 5);

        assertEquals(result3.length, heapResult3.length);

        for (Object obj : heapResult3) {
            assertTrue(Arrays.asList(result3).contains(obj));
        }
    }
}