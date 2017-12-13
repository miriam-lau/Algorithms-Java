package elements_of_programming_interviews;

/*
 * 8.8 Implement a circular queue
 * Implement a queue API using an array for storing elements. API should include:
 *  1) constructor which takes as argument the initial capacity of the queue
 *  2) enqueue and dequeue functions
 *  3) function which returns the number of elements stored.
 *  4) dynamic resizing to support storing an arbitrarily large number of elements.
 *
 * Solution: Need to keep track of start and end Index in the queue
 * Time complexity:
 * Space complexity:
 */
public class MyQueues {
    public int capacity;
    public int numValues = 0;
    public int[] values;
    public int startIndex = 0;
    public int addIndex = 0;

    public MyQueues(int capacity) {
        this.capacity = capacity;
        this.values = new int[capacity];
    }

    // Resize array if array is full.
    public void resize() {
        int currCapacity = this.capacity;

        // Double the size of the array.
        this.capacity *= 2;
        int[] newValues = new int[this.capacity];
        int index = 0;

        // Loop through values and copy each value to new array.
        while (index < numValues) {
            if (startIndex == currCapacity) {
                startIndex = 0;
            }

            newValues[index] = this.values[startIndex];
            startIndex++;
            index++;
        }

        this.values = newValues;
        this.startIndex = 0;
        this.addIndex = numValues;
    }

    // Handle resizing if array is full, then add num to end of queue.
    public void enqueue(int num) {
        if (this.numValues == this.capacity) {
            this.resize();
        }

        this.values[addIndex] = num;
        this.numValues++;
        this.addIndex++;

        if (this.addIndex == this.capacity) {
            addIndex = 0;
        }
    }

    // Remove from start of the queue and return the num removed.
    public int dequeue() {
        int deletedNum = this.values[startIndex];
        // Set value to a invalid number
        this.values[startIndex] = Integer.MIN_VALUE;
        this.startIndex++;
        this.numValues--;

        if (this.startIndex == this.capacity) {
            this.startIndex = 0;
        }

        return deletedNum;
    }

    // Return the number of elements currently in the queue.
    public int size() {
        return numValues;
    }
}
