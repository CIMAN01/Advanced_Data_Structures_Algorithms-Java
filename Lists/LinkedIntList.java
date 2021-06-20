// Building Java Programs

// class LinkedIntList can be used to store a list of integers.
public class LinkedIntList implements IntList {

    private ListNode front; // first value in the list

    // post: constructs an empty list
    public LinkedIntList() {
        front = null;
    }

    // post: returns the current number of elements in the list
    public int size() {
        int count = 0;
        ListNode current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return nodeAt(index).data;
    }

    // post: returns comma-separated, bracketed version of list
    public String toString() {
        if (front == null) {
            return "[]";
        }
        else {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post: returns the position of the first occurrence of the
    // given value (-1 if not found)
    public int indexOf(int value) {
        int index = 0;
        ListNode current = front;
        while (current != null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value);
        }
        else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode(value, front);
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = new ListNode(value, current.next);
        }
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    // pre : 0 <= i < size()
    // post: returns a reference to the node at the given index
    private ListNode nodeAt(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // pre : list is in sorted (non-decreasing) order
    // post: given value is added to the list so as to preserve sorted (non-decreasing) order, duplicates allowed
    public void addSorted(int value) {
        //   empty list   ||    front of list
        if (front == null || front.data >= value) { // robust test must come before sensitive test
            front = new ListNode(value, front);
        } else {
            ListNode current = front;
            //         back of list     &&      middle of list
            while (current.next != null && current.next.data < value) { // robust test must come before sensitive test
                current = current.next;
            }
            current.next = new ListNode(value, current.next);
        }
    }

    // inchworm approach
    public void addSorted2(int value) {
        if (front == null || front.data >= value) {
            front = new ListNode(value, front);
        } else {
            ListNode prev = front;
            ListNode current = front.next;
            while (current != null && current.data < value) {
                prev = current;
                current = current.next;
            }
            prev.next = new ListNode(value, prev.next);
        }
    }

    // another variation
    public void addSorted3(int value) {
        ListNode prev = null;
        ListNode current = front;
        while (current != null && current.data < value) {
            prev = current;
            current = current.next;
        }
        if (prev == null) {
            front = new ListNode(value, front);
        } else {
            prev.next = new ListNode(value, prev.next);
        }
    }

}

