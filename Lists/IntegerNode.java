// Data Structures and Algorithms Deep Dive Using Java - Challenge2:

// Implement a method in the IntegerLinkedList class that inserts a value in sorted order.

// Lower values should appear first in the list (be closer to the head).

//  If we insert 4, 2, 1, 5, list should look like Head->1->2->-4->5->null

//  IntegerLinkedList is a singly-linked list

public class IntegerNode {

    private Integer value;
    private IntegerNode next;

    public IntegerNode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public IntegerNode getNext() {
        return next;
    }

    public void setNext(IntegerNode next) {
        this.next = next;
    }

    public String toString() {
        return value.toString();
    }

}
