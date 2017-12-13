package elements_of_programming_interviews;


public class MyLinkedLists {
    /*
     * 7.2 Reverse a single sublist
     * Input: a singly linked list L, and two ints, start and finish
     * Output: reverses order of the start node to finish node inclusive, first node starts as 1.
     * Restrictions: Do not allocate additional nodes.
     *
     * Solution: Need to have a pointer to the node before start and node after finish, so after reversing the sublist
     *  the sublist and other nodes point to the correct node.
     */
    public Node reverseSublist(Node node, int start, int finish) {
        Node startNode = node;
        Node beforeStart = null;
        // Need to initialize nodeIndex to 1, if start is the first node.
        int nodeIndex = 1;

        if (start != 1) {
            beforeStart = node;
            startNode = node.next;
            // Need to increment nodeIndex here, so nodeIndex will be at the correct node when reversing sublist.
            nodeIndex++;

            // Find the node before start and the start node.
            while (nodeIndex < start) {
                beforeStart = beforeStart.next;
                startNode = startNode.next;
                nodeIndex++;
            }
        }

        // Now reverse sublist from start to finish (inclusive).
        Node prevNode = null;
        Node currNode = startNode;

        while (nodeIndex <= finish) {
            // Set nextNode to currNode's next node
            Node nextNode = currNode.next;
            // Set currNode's next node to prevNode: change pointer from pointing to the nextNode to prevNode.
            currNode.next = prevNode;
            // Move pointers for prevNode and currNode to their next nodes: set prevNode to currNode and currNode to
            //  nextNode
            prevNode = currNode;
            currNode = nextNode;
            nodeIndex++;
        }

        // Now currNode points to the node after finish
        // Need to link the nodes before the original start node and after the original finish node. prevNode is at
        //  start position and startNode is at finish position.
        startNode.next = currNode;

        if (start == 1) {
            return prevNode;
        }

        beforeStart.next = prevNode;

        return node;
    }

    /*
     * 7.3 Test for cyclicity (James already solved)
     * Input: head of a singly linked list
     * Output: returns null if a cycle does not exist or the node at the start of the cycle if a cycle exists
     * Do not know the length of the linked list.
     *
     * Solution:
     *  1) Determine if a cycle is present using a slow and fast iterator to traverse the list.
     *  -- Steps below are if a cycle is found --
     *  2) Find the cycle length by storing the number of advances in a variable, then advancing either the slow or fast
     *      iterator by one until they meet again.
     *  3) Create a new pointer pointing to the head, say pointer 'a', and advance it by the cycle length.
     *  4) Create another new pointer pointing to the head, say pointer 'b', and advance both pointers 'a' and 'b' in
     *      tandem until they meet. The meet point is the start of the cycle.
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
}
