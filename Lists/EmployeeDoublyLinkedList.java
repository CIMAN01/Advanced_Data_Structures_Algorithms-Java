// Data Structures and Algorithms Deep Dive Using Java

public class EmployeeDoublyLinkedList {

    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    public void addToFront(Employee employee) {

        EmployeeNode node = new EmployeeNode(employee);

        if (head == null) {
            tail = node;
        }
        else {
            head.setPrevious(node);
            node.setNext(head);
        }
        head = node;
        size++;
    }

    public void addToEnd(Employee employee) {

        EmployeeNode node = new EmployeeNode(employee);

        if (tail == null) {
            head = node;
        }
        else {
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        size++;
    }

    // implement the addBefore() method
    public boolean addBefore(Employee newEmployee, Employee existingEmployee) {

        // challenge1:

        // return true if you were able to successfully add the employee into the list before the existing employee.
        // Return false if the existing employee doesn't exist in the list

        // if the list is empty
        if (head == null) { // or isEmpty()
            return false;
        }

        // find the existing employee
        EmployeeNode current = head;

        // either the existing employee is not in the list (current == null) or the existing employee is indeed in the list
        while(current != null && !current.getEmployee().equals(existingEmployee)) {
            current = current.getNext();
        }

        // if the existing employee is not found after the loop terminates there's nothing left to do
        if (current == null) { // handle null case
            return false;
        }

        // create a new node for the new employee
        EmployeeNode newNode = new EmployeeNode(newEmployee);

        // wire up the new node in 4 steps
        newNode.setPrevious(current.getPrevious()); // make new employee's previous field point to the node that was previously in front of the existing employee node
        newNode.setNext(current); // make new employee's next field point to the existing employee node
        current.setPrevious(newNode); // make existing employee's previous field point to the new employee node
        // handle special case if the existing employee is at the head of list
        if (head == current) {
            head = newNode; // new employee now becomes the head of the list
        }
        // if existing employee is not the head then we have to handle the next field of the node that was in front of the current node (existing employee)
        else {
           newNode.getPrevious().setNext(newNode); // we have to use newNode.getPrevious() instead of current.getPrevious() because the field was changed on line 65
        }

        // increment the size since we added a new employee
        size++;

        // if we reach this line of code, then we were able to successfully insert the new employee into the list in front of the existing employee
        return true;
    }

    // remove a node from the front of the list ( O(1) time complexity as long we remove from the front/back of the list)
    public EmployeeNode removeFromFront() {
        // if the list is empty
        if (isEmpty()) {
            return null;
        }

        EmployeeNode removedNode = head;

        // if head is the only node in the list
        if (head.getNext() == null) {
            tail = null;
        }
        else {
            head.getNext().setPrevious(null);
        }

        head = head.getNext();
        size--;
        // set the removed node to null (optional)
        removedNode.setNext(null);

        return removedNode;
    }

    // remove a node from the back of the list ( O(1) time complexity as long we remove from the front/back of the list)
    public EmployeeNode removeFromEnd() {
        // if list is empty
        if (isEmpty()) {
            return null;
        }

        EmployeeNode removedNode = tail;

        // if tail is the only node in the list
        if (tail.getPrevious() == null) {
            head = null;
        }
        else {
            tail.getPrevious().setNext(null);
        }

        tail = tail.getPrevious();
        size--;
        // set the removed node to null (optional)
        removedNode.setPrevious(null);

        return removedNode;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        EmployeeNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" <=> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}

