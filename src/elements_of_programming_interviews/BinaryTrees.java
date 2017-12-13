package elements_of_programming_interviews;


public class BinaryTrees {
    /*
     * 9.4 Compute the LCA when nodes have parent pointers
     * Input: given two nodes in a binary tree
     * Output: compute their LCA (lowest common ancestor), assume each node has a parent pointer.
     * Are nodes at same depth? (assume no).
     *
     * Solution: Since nodes may not be at the same depth, will need to calculate the depth of each node first. The
     *  node that is at the greater depth will traverse up its parent until the parent is at the same depth as the
     *  second node. Then compare each of their parents and continue up the tree until the LCA is found.
     * Time complexity: O(h), where h is the height of the tree, worst case the LCA is the root node
     * Space complexity: O(1)
     */
    // James: BtNode node1, BTNode node2
    public BTNode findLCA(BTNode one, BTNode two) {
        // Find the depths of the nodes.
        // James: node1Depth
        int depthOfOne = 0;
        int depthOfTwo = 0;
        // James: Should be a different name but not sure what. node1Ptr maybe.
        BTNode oneCopy = one;
        BTNode twoCopy = two;


        while (oneCopy.parent != null) {
            depthOfOne++;
            oneCopy = oneCopy.parent;
        }

        while (twoCopy.parent != null) {
            depthOfTwo++;
            twoCopy = twoCopy.parent;
        }

        // Traverse up the tree until both nodes are at the same depth.
        oneCopy = one;
        twoCopy = two;

        while (depthOfOne > depthOfTwo) {
            oneCopy = oneCopy.parent;
            depthOfOne--;
        }

        while (depthOfTwo > depthOfOne) {
            twoCopy = twoCopy.parent;
            depthOfTwo--;
        }

        // Find LCA.
        if (oneCopy == twoCopy) {
            return oneCopy;
        }

        while (oneCopy.parent != null && twoCopy.parent != null) {
            if (oneCopy.parent == twoCopy.parent) {
                return oneCopy.parent;
            } else {
                oneCopy = oneCopy.parent;
                twoCopy = twoCopy.parent;
            }
        }

        return null;
    }
}
