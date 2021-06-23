
import java.util.LinkedList;
import java.util.ListIterator;

// implement a custom class instead of using the JDK LinkedList class in order to prevent the end-user
// from using anything other than push, pop, peek methods (maintain stack behavior)
public class LinkedStack {

    // using a LinkedList field that will backup the stack
    private LinkedList<Employee> stack;

    // constructor
    public LinkedStack() {
        stack = new LinkedList<>();
    }

    // add (push) an employee to the stack
    public void push(Employee employee) {
        stack.push(employee);
    }

    // remove (pop) an employee from the stack
    public Employee pop() {
        return stack.pop();
    }

    // show (peek at) the employee without removing (popping) from the stack
    public Employee peek() {
        return stack.peek();
    }

    // check whether a stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // print the stack using enhanced for-loop
    public void printStack() {
        for (Employee employee : stack) {
            System.out.println(employee);
        }
    }

    // print the stack using a list iterator
    public void printStackIterator() {
        ListIterator<Employee> iterator = stack.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
