

import java.util.EmptyStackException;

public class ArrayStack {

    private Employee[] stack;
    private int top;

    public ArrayStack(int capacity) {
        stack = new Employee[capacity];
    }

    // if no resizing is needed this method will have runtime of O(1), otherwise it's O(n)
    public void push(Employee employee) {
        // O(n) runtime when if statement is executed
        if (top == stack.length) {
            // need to resize the backing array
            Employee[] newArray = new Employee[2 * stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }
        // this operation has runtime of O(1)
        stack[top++] = employee; // top always points to the next available position
    }

    // O(1) runtime
    public Employee pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // top always points to the next available position
        Employee employee = stack[--top];
        stack[top] = null;
        return employee;
    }

    // peek is always O(1)
    public Employee peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    // the size is just the value of top (if we only have one item (located at index 0), then top will be 1 since it's the next available position at index 1)
    public int size() {
        return top; // top always points to the next available position
    }

    public boolean isEmpty() {
        return top == 0;
    }

    // print the stack like you would an array
    public void printStack() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

}
