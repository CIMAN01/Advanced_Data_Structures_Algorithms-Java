// Data Structures and Algorithms Deep Dive Using Java - Challenge2:

// Implement a method in the IntegerLinkedList class that inserts a value in sorted order.

// Lower values should appear first in the list (be closer to the head).

//  If we insert 4, 2, 1, 5, list should look like Head->1->2->-4->5->null

//  IntegerLinkedList is a singly-linked list

public class IntegerLinkedList {

    private IntegerNode head;
    private int size;

    public void addToFront(Integer value) {
        IntegerNode node = new IntegerNode(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public IntegerNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        IntegerNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    // challenge2 - implement the method that inserts a value in sorted order
    public void insertSorted(Integer value) {
        // if list is empty OR whether the value of the first node in the list is greater than or equal to the value we're inserting (the list must be sorted for this to work)
        if(head == null || head.getValue() >= value ) {
            // add the value to the front
            addToFront(value);
            return;
        }
        // if the list is not empty, find the insertion point:

        // because we're dealing with a singly LinkedList we need two fields, one for traversing the list and another to keep track of the previous node in the list
        IntegerNode current = head.getNext(); // here  we start at head.getNext() since we already checked the head above in the if statement
        IntegerNode previous = head; // this node will always be one position behind the current node
        // keep searching the list until we find a value greater than or equal to the value that's being inserted
        while(current != null && current.getValue() < value) {
            previous = current;
            current = current.getNext();
        }
        // create a new node for the value to be inserted
        IntegerNode newNode = new IntegerNode(value);
        // insert the new node in front the current node (if current is null, newNode.setNext(current) will just be a redundant inexpensive operation, which is fine)
        newNode.setNext(current); // new node's next field will point to current
        // handle the previous's next field
        previous.setNext(newNode); // previous's next field now has to point to the new node
        // update the size
        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        IntegerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
