import java.util.PriorityQueue;

// this class uses a min-heap
public class PriorityQueues {
    // main method
    public static void main(String[] args) {
        // create a new priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // add some items
        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);

//        System.out.println(pq.peek());
//        System.out.println(pq.remove()); // will remove an item at root unless it is passed a specific value
//        System.out.println(pq.peek());
//        System.out.println(pq.poll()); // poll and remove both delete an item
//        System.out.println(pq.peek());

        // remove a random item instead of the root
        System.out.println(pq.remove(54)); // returns true if the item exists, false otherwise
        // create an array from the queue
        Object[] ints = pq.toArray();
        // iterate over the array and print each value
        for (Object num: ints) {
            System.out.println(num);
        }

        //System.out.println(pq.peek());
        pq.add(-1); // since we're dealing with a MIN-HEAP, this number will become the new root once -3492 is removed
        //System.out.println(pq.peek());
    }

}
