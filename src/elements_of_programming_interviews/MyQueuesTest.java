package elements_of_programming_interviews;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class MyQueuesTest {
    MyQueues myQueue;

    @Before public void initialize() {
        myQueue = new MyQueues(5);
    }

    @Test
    public void enqueue() throws Exception {
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);

        int[] result = new int[] {1, 2, 3, 4};
        int startIndex = myQueue.startIndex;

        for (int i = 0; i < myQueue.numValues; i++) {
            assertEquals(result[i], myQueue.values[startIndex]);
            startIndex++;
        }

        assertEquals(0, myQueue.startIndex);
        assertEquals(4, myQueue.addIndex);
        assertEquals(4, myQueue.numValues);

        myQueue.enqueue(5);
        myQueue.dequeue();

        assertEquals(1, myQueue.startIndex);
        assertEquals(0, myQueue.addIndex);
        assertEquals(4, myQueue.numValues);

        myQueue.enqueue(6);
        myQueue.enqueue(7);

        assertEquals(6, myQueue.numValues);
        assertEquals(10, myQueue.capacity);

        result = new int[] {2, 3, 4, 5, 6, 7};
        startIndex = myQueue.startIndex;

        for (int i = 0; i < myQueue.numValues; i++) {
            assertEquals(result[i], myQueue.values[startIndex]);
            startIndex++;
        }
    }

    @Test
    public void dequeue() throws Exception {
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);

        assertEquals(1, myQueue.dequeue());
        assertEquals(3, myQueue.numValues);
        assertEquals(1, myQueue.startIndex);
    }

    @Test
    public void size() throws Exception {
        assertEquals(0, myQueue.size());

        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);

        assertEquals(4, myQueue.size());
    }

}