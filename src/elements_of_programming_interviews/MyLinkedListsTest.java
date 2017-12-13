package elements_of_programming_interviews;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MyLinkedListsTest {
    MyLinkedLists myList;

    Node a;
    Node b;
    Node c;
    Node d;
    Node e;
    Node f;
    Node g;

    @Before public void initialize() {
        myList = new MyLinkedLists();

        g = new Node(16, null);
        f = new Node(15, g);
        e = new Node(14, f);
        d = new Node(13, e);
        c = new Node(12, d);
        b = new Node(11, c);
        a = new Node(10, b);
    }

    @Test
    public void reverseSublist() throws Exception {
        Node currNode = a;
        while (currNode != null) {
            currNode = currNode.next;
        }

        Node head = myList.reverseSublist(a, 2, 5);
        List<Integer> result = new ArrayList<>(Arrays.asList(10, 14, 13, 12, 11, 15, 16));
        int index = 0;

        while (head != null) {
            int num = result.get(index);
            assertEquals(num, head.data);

            index++;
            head = head.next;
        }

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = null;

        head = myList.reverseSublist(a, 3, 7);
        result = new ArrayList<>(Arrays.asList(10, 11, 16, 15, 14, 13, 12));
        index = 0;

        // James: This while loop is duplicated code. Better to write a function used in this test file that
        // takes a linked list and populates an arraylist with the values by traversing it. Then you can do 
        // assertArrayListEquals or whatever that function is.
        while (head != null) {
            int num = result.get(index);

            assertEquals(num, head.data);

            index++;
            head = head.next;
        }

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = null;

        head = myList.reverseSublist(a, 1, 5);
        result = new ArrayList<>(Arrays.asList(14, 13, 12, 11, 10, 15, 16));
        index = 0;

        while (head != null) {
            int num = result.get(index);

            assertEquals(num, head.data);

            index++;
            head = head.next;
        }

    }

}
