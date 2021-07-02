
import java.util.NoSuchElementException;

// a circular queue that wraps around the array
public class CircularArrayQueue {

    // fields
    private Employee[] queue;
    private int front;
    private int back;

    // constructor
    public CircularArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    // add method
    public void add(Employee employee) {
        // handle empty spaces occupying the front of the queue (will resize the array if it cannot wrap around the queue)
        if (size() == queue.length - 1) { // will still resize if there's one empty space left
            // save the size (will need it after resizing the array)
            int numItems = size();
            // resize the array
            Employee[] newArray = new Employee[2 * queue.length];
            // unwrap the queue and reset the front of the queue to zero:
            // copy the front and following items before the wrap-around to the beginning of a new array (reset the queue to the front)
            System.arraycopy(queue, front, newArray, 0, queue.length - front);
            // then, copy the remaining back items to the array (back equals the number of items that have been wrapped to the front)
            System.arraycopy(queue, 0, newArray, queue.length - front, back);
            // assign new array to queue
            queue = newArray;
            // reset the front and the back field
            front = 0;
            back = numItems; // cannot use size()

        }
        // an employee will always be added to the back of the queue (FIFO)
        queue[back] = employee;
        // check if we need to wrap back to the front of queue
        if (back < queue.length - 1) {
            back++; // increment back (no wrapping needed)
        }
        else {
            back = 0; // reset back (wrap back to the front of queue)
        }

        // 0   jane
        // 1    john
        // 2  -   -back
        // 3  -mike - front
        // 4   -bill

        // 0 mike
        // 1 bill
        // 2 jane
        // 3 john
        // 4 - back
        // 5
        // 9
    }

    // remove method
    public Employee remove() {
        // handle an empty queue
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        Employee employee = queue[front];
        // clean up front of the queue
        queue[front] = null;
        front++;
        // reset the queue if empty
        if (size() == 0) {
            front = 0;
            back = 0;
        }
        // if front item has been removed, wrap front to the beginning
        else if (front == queue.length) {
            front = 0; // reset front
        }
        return employee;
    }

    // peek at the front of the queue
    public Employee peek() {
        //
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    // get the size of the queue
    public int size() {
        // check if queue has wrapped
        if (front <= back) { // if the queue hasn't wrapped
            return back - front; // get the number of items in the queue by simply subtracting back from front
        }
        // however, if the queue has wrapped
        else {
            // adjust for the negative number to the actual number of items on the queue by adding the length of queue
            return back - front + queue.length;
        }
    }

    // print the queue
    public void printQueue() {
        // if the queue hasn't wrapped
        if (front <= back) {
            // notice i < back (back always points to the next available position in the queue)
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
        // however, if the queue has wrapped
        else {
            // print the items from the front of the queue to the end of the array
            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            // print the remaining (wrapped) items that start from the beginning of the array to the front of the queue
            for (int i = 0; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
    }

}
