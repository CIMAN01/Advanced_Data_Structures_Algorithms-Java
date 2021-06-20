// Data Structures and Algorithms Deep Dive Using Java - Challenge2:

// Implement a method in the IntegerLinkedList class that inserts a value in sorted order.

// Lower values should appear first in the list (be closer to the head).

//  If we insert 4, 2, 1, 5, list should look like Head->1->2->-4->5->null

//  IntegerLinkedList is a singly-linked list

public class Challenge2 {

    public static void main(String[] args) {

        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;

        IntegerLinkedList list = new IntegerLinkedList();
        list.insertSorted(three);
        list.printList(); // HEAD -> 3 -> null
        list.insertSorted(two);
        list.printList(); // HEAD -> 2 -> 3 -> null
        list.insertSorted(one);
        list.printList(); // HEAD -> 2 -> 3 -> null
        list.insertSorted(four);
        list.printList(); // HEAD -> 1 -> 2 -> 3 -> 4 -> null
    }

}
