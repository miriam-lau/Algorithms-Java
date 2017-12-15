package elements_of_programming_interviews;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class BinarySearchTreesTest {
    BinarySearchTrees tree;

    BTNode A;
    BTNode B;
    BTNode C;
    BTNode D;
    BTNode E;
    BTNode F;
    BTNode G;
    BTNode H;

    @Before
    /* Binary Tree
     *                       A.data = 5
     *                   /                \
     *             B.data = 3           C.data = 9
     *            /          \         /
     *       D.data = 1  E.data = 4  F.data = 7
     *            \                       \
     *         G.data = 2              H.data = 8
     */
    public void initialize() {
        tree = new BinarySearchTrees();
        A = new BTNode(5, null, null, null);
        B = new BTNode(3, null, null, null);
        C = new BTNode(9, null, null, null);
        D = new BTNode(1, null, null, null);
        E = new BTNode(4, null, null, null);
        F = new BTNode(7, null, null, null);
        G = new BTNode(2, null, null, null);
        H = new BTNode(8, null, null, null);

        A.left = B;
        A.right = C;

        B.parent = A;
        B.left = D;
        B.right = E;

        D.parent = B;

        E.parent = B;
        E.right = G;

        G.parent = E;

        C.parent = A;
        C.left = F;

        F.parent = C;
        F.right = H;

        H.parent = F;
    }

    @Test
    public void findGreaterKey() throws Exception {
        assertEquals(F, tree.findGreaterKey(A, 6));
        assertEquals(null, tree.findGreaterKey(A, 10));
    }

    @Test
    public void findKLargest() throws Exception {
        List<Integer> result1 = new ArrayList<>(Arrays.asList(9, 8, 7));
        List<Integer> result2 = new ArrayList<>();

        assertEquals(result1, tree.findKLargest(A, 3));
        assertEquals(result2, tree.findKLargest(A, 0));
    }

}