/* challenge: use a stack and a queue to check if string is a Palindrome */

import java.util.LinkedList;

// Palindrome class
public class QueuesChallenge {

    // a method that checks whether a string is a palindrome
    public static boolean checkForPalindrome(String string) {
        // use a LinkedList for both a stack and a queue
        LinkedList<Character> stack = new LinkedList<>(); // LIFO behavior
        LinkedList<Character> queue = new LinkedList<>(); // FIFO behavior
        // change the lower case
        String lowerCase = string.toLowerCase();
        // iterate over the string
        for (int i = 0; i < lowerCase.length(); i++) {
            // store each character
            char c = lowerCase.charAt(i);
            // check if character is a lower case letter
            if (c >= 'a' && c <= 'z') { // handle any punctuation or white space
                queue.addLast(c); // insert a character at the end of the queue (fifo behavior: we always add at the back of the queue)
                stack.push(c); // push character onto the stack
            }
        }
        // while stack is not empty
        while (!stack.isEmpty()) {
            // characters from the stack will be read from right to left while the characters from queue will be read from left to right
            if (!stack.pop().equals(queue.removeFirst())) { // removeFirst -> fifo behavior dictates we always remove an item at the front of the queue
                return false; // if character from right side does not equal the character from left side it is not a palindrome
            }
        }
        return true; // if character from right side equals the character from left side it is a palindrome
    }

    // main method
    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

}
