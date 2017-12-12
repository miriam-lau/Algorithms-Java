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
}
