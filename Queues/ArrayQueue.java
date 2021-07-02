
import java.util.NoSuchElementException;

public class ArrayQueue {

    private Employee[] queue; // queue employee array
    private int front; // front of the queue
    private int back; // back of the queue

    public ArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee employee) {
        // check if array needs to be resized
        if (back == queue.length) {
            Employee[] newArray = new Employee[2 * queue.length];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }
        // we always add items to the back of the queue
        queue[back] = employee;
        // point to the next available position to add an item
        back++;
    }

    public Employee remove() {
        // check if queue is empty and throw an exception if it is (cannot remove an item from an empty queue)
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        // we always remove an item from the front of the queue
        Employee employee = queue[front];
        // null out front
        queue[front] = null; // clean up
        // front is now the next item in the queue
        front++;
        // perform an optimization: check the size and reset the queue if size is zero
        if (size() == 0) { //
            front = 0; // reset front
            back = 0; // reset back
        }
        return employee;
    }


    public Employee peek() {
        // check if queue is empty and throw an exception if it is (cannot peek at an item in an empty queue)
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        // peek only looks at the front of the queue, but doesn't remove anything
        return queue[front];
    }

    // size tells us how many items there are in the queue
    public int size() {
        return back - front;
    }

    public void printQueue() {
        // must be i < back because back always points to next position that the item will be added to
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }

}
