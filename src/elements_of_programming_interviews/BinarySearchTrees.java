package elements_of_programming_interviews;


import java.util.ArrayList;
import java.util.List;

public class BinarySearchTrees {
    /*
     * 14.2 Find the first key greater than a given value in a BST
     * Input: BST and a value
     * Output: returns the first key that would appear in an inorder traversal which is greater than the input value.
     *
     * Inorder traversal visit left, then root, then right.
     * BST property: a node >= nodes in its left subtree and <= to nodes in its right subtree.
     *
     * Time complexity: O(h), h is height of the tree
     * Space complexity:
     */
    public BTNode findGreaterKey(BTNode root, int value) {
        BTNode subtree = root;
        BTNode result = null;

        while (subtree != null) {
            if (subtree.data > value) {
                result = subtree;
                subtree = subtree.left;
            } else {
                subtree = subtree.right;
            }
        }

        return result;
    }

    /*
     * 14.3 Find the k largest elements in a BST
     * Input: BST and an integer k
     * Output: returns the k largest elements in the BST in decreasing order
     *
     * Solution: Traverse in reverse order of an inorder: visit right, root, then left.
     * Time complexity: O(h), h is height of the tree
     * Space complexity: O(k), number of elements to return.
     */
    public List<Integer> findKLargest(BTNode root, int k) {
        List<Integer> result = new ArrayList<>();

        // Recursively call a function.
        findKLargestHelper(root, k, result);

        return result;
    }

    // Traverses in reverse inorder.
    public static void findKLargestHelper(BTNode node, int k, List<Integer> result) {
        if (node != null && result.size() < k) {
            findKLargestHelper(node.right, k, result);

            if (result.size() < k) {
                result.add(node.data);
                findKLargestHelper(node.left, k, result);
            }
        }
    }
}
