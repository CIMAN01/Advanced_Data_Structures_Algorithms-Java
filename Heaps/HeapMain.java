
// main Class
public class HeapMain {

    // main method
    public static void main(String[] args) {
        // create a new Heap with a given capacity
        Heap heap = new Heap(10);
        // insert value (build the heap)
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);
        // print the heap
        heap.printHeap();
//        // peek at the root of the heap
//        System.out.println(heap.peek());
//        // delete the root node
//        heap.delete(0);
//        // print the heap
//        heap.printHeap();
//        // peek at the root of the heap
//        System.out.println(heap.peek());
        // sort the heap
        heap.sort();
        // print the heap
        heap.printHeap();
    }
    
}
