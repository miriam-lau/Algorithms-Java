package elements_of_programming_interviews;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class BinaryTreesTest {
    BinaryTrees tree;

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
     *                     A
     *                  /     \
     *                 B       C
     *                / \     /
     *               D   E   F
     *                    \   \
     *                     G   H
     */
    public void initialize() {
        tree = new BinaryTrees();
        A = new BTNode(1, null, null, null);
        B = new BTNode(2, null, null, null);
        C = new BTNode(3, null, null, null);
        D = new BTNode(4, null, null, null);
        E = new BTNode(5, null, null, null);
        F = new BTNode(6, null, null, null);
        G = new BTNode(7, null, null, null);
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
    public void findLCA() throws Exception {
        assertEquals(A, tree.findLCA(G, H));
        assertEquals(E, tree.findLCA(E, G));
    }
}
