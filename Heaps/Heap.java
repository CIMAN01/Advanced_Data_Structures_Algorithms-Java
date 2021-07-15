/*
 - A (Binary) Heap is a special type of binary tree (not to be confused with heap memory)

 - Heaps are usually implemented as arrays

 - Heaps have to meet the following heap property:

    1. Must a complete tree (all levels are completely filled except possibly the last level and the last level has all nodes as left as possible)

    2. A heap is either min heap or max heap. In a Min Binary Heap, the node at root must be minimum among all nodes present in the heap.
       Similarly, In a max heap, the node at root must be maximum among all nodes present in the heap.

*/

// a Max-Heap class
public class Heap {
    // need two fields
    private int[] heap; // the array
    private int size; // and the next available position

    // a constructor that creates and initializes an array
    public Heap(int capacity) {
        // the caller decides how big the array should be
        heap = new int[capacity];
    }

    // an insertion method for the heap -> time complexity: O(log n)
    public void insert(int value) {
        // check if heap is full, and throw an error if it is
        if (isFull()) {
            // exception is thrown because the array is full and a new element cannot be added
            throw new IndexOutOfBoundsException("Heap is full");
        }
        // size is next available position
        heap[size] = value; // put the item at first available spot -> O(1) constant time operation
        // a call to method to heapify the heap
        fixHeapAbove(size); // potentially fixing the heap (swapping values) -> Log n swaps -> O(log n)
        // increment the size
        size++;
    }

    // a method that peaks at the root of the heap
    public int peek() {
        // if heap is empty
        if(isEmpty()) {
            // throw an exception to caller
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        // return the root of the heap
        return heap[0];
    }

    // a deletion method for the heap -> time complexity: O(log n) because usually we're only interested in removing the root (and not some random value that requires a linear search time complexity)
    public int delete(int index) {
        // check if heap is full, and throw an error if it is
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        int parent = getParent(index); // get the parent (index of parent)
        int deletedValue = heap[index]; // save the deleted value (this gets returned by method)
        // replacement step:
        // store replacement value where the deleted value used to be (replacement value -> the right-most position in the array)
        heap[index] = heap[size - 1]; // size will always the next available position so here the index is going be size-1
        // if it's the root and if replacement value is less than parent (which meets the heap property), we can only look below
        if (index == 0 || heap[index] < heap[parent]) { // if the deleted node was the root and if the replacement value less than its parent
            // look down the tree and heapify if needed -> Log n swaps -> O(log n)
            fixHeapBelow(index, size - 1); // look at the tree below the heap index
        }
        else { // otherwise, look above
            fixHeapAbove(index);
        }
        // decrement the size after deleting a node
        size--;
        // return the value that was deleted earlier
        return deletedValue;
    }

    // a heap sort method (max-heap) -> O(n log n)
    public void sort() { /* important note: once you sort a heap you no longer have a heap (the structure of the heap breaks down) */
        // the last heap index will equal size minus one when we start out
        int lastHeapIndex = size - 1;
        // iterate over the heap (array) -> swapping n element -> O(n) in place algorithm
        for (int i = 0; i < lastHeapIndex; i++) { // rinse and repeat process of sorting
            // exchange (swap) the root with the last item
            int tmp = heap[0]; // largest value in the heap (array)
            heap[0] = heap[lastHeapIndex - i]; //  the heap (array) will shrink after each exchange which is why i is subtracted during each iteration
            heap[lastHeapIndex - i] = tmp;
            // fix the heap -> 'heapify' the heap -> O(log n)
            fixHeapBelow(0, lastHeapIndex - i - 1); // subtract by one to exclude the exchanged/swapped root
        }
    }

    // a method that 'heapifies' the heap (this is max heap) when looking up the heap (travelling up the tree)
    private void fixHeapAbove(int index) {
        // store the new value that was just inserted
        int newValue = heap[index];
        // while we haven't hit the root (happens when index hits zero) and while the new value is greater than its parent -> swap the new value with its parent
        while (index > 0 && newValue > heap[getParent(index)]) {
            // compare new value with its parent (shifting parents down)
            heap[index] = heap[getParent(index)]; // assign the parent value to where we added the new value
            index = getParent(index); // update the index to the parent's position
        }
        // only once we've found its correct position (happens when we drop out of the loop) do we actually assign the new value
        heap[index] = newValue; // assign the new value into the parent's position
    }

    // a method that 'heapifies' the heap (this is max heap) when looking down the heap (travelling down the tree)
    private void fixHeapBelow(int index, int lastHeapIndex) { // lastHeapIndex -> size - 1
        // a field for swapping the child
        int childToSwap;
        // swapping phase: compare the node at index with its two children, and swap if needed
        // if the value at heap index is less than either of its children, swap it with the child that has the greatest value
        while (index <= lastHeapIndex) { // index is the heap index (index of the replacement value or position where a node was deleted)
            // get the two children of the element at position index
            int leftChild = getChild(index, true); // get left child if true
            int rightChild = getChild(index, false); // get right child if false
            // check for children, if we have children we might have to heapify:
            // first, check if node has a left child
            if (leftChild <= lastHeapIndex) { // check left child then right child because a heap has to be complete tree, meaning there cannot be a node with only a right child!
                // if rightChild > lastHeapIndex it means there's no right child since it's outside the bounds of the heap (means it's not part of the heap)
                if (rightChild > lastHeapIndex) { // check if node has a right child
                    // if no right child then child to swap is left child
                    childToSwap = leftChild;
                }
                // else there is a right child, now compare which one is largest
                else {
                    // child to swap will be the child with the largest value (the index of the largest child will be stored)
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }
                // now compare heap (parent) to the child:
                // if the heap is less than the child
                if (heap[index] < heap[childToSwap]) {
                    // swap the heap (parent) with the child
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                }
                // otherwise, if the heap is larger than the child, then the heap is good and we want to break out of the loop
                else {
                    break;
                }
                // now we have to compare the replacement value with its new children
                index = childToSwap; // update the index (and loop back around)
            }
            // otherwise, if there aren't any children no 'heapifying' is needed, break out of the loop
            else {
                break;
            }
        }
    }

    // a method for printing the heap
    public void printHeap() {
        // iterate over the array
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i]); // print the value at each iteration
            System.out.print(", ");
        }
        System.out.println();
    }

    // method that checks if a heap is full
    public boolean isFull() {
        return size == heap.length;
    }

    // a utility method for getting the parent for an element in the array
    public int getParent(int index) {
        // a formula for getting the parent (its index)
        return (index - 1) / 2; // floor((index - 1) / 2)
    }

    // a method for checking if the heap is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // a method for getting a child of an element in the array
    public int getChild(int index, boolean left) { // index -> index of parent and if left is true we want the left child and if false we want the right child
        // formula -> 2*i + 1 (left child) or 2*i + 2 (right child)
        return 2 * index + (left ? 1 : 2);
    }

}
