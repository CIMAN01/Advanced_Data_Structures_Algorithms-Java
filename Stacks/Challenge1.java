// Using a stack, determine whether a string is a palindrome

// Strings may contain punctuation and spaces. They should be ignored. Case should be ignored.

import java.util.LinkedList;


public class Challenge1 {

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

    // challenge: implement a method that checks whether a string is a palindrome
    public static boolean checkForPalindrome(String string) {
        // create a new stack using a LinkedList
        LinkedList<Character> stack = new LinkedList<>();
        // create a String builder that only contains letters
        StringBuilder stringLettersOnly = new StringBuilder(string.length()); // will contain no whitespace, punctuation, or upperCase letters
        // create another temp string that uses lower case letters that will be used for the loop
        String lowerCaseString = string.toLowerCase();
        // loop through the input string and populate the new string with letters only
        for (int i = 0; i < lowerCaseString.length(); i++) {
            // store each character from index i
            char c = lowerCaseString.charAt(i);
            // look for characters between a and z
            if(c >= 'a' && c <= 'z') {
               stringLettersOnly.append(c); // append each character to the string
               stack.push(c); // push each character to the stack
            }
        }
        // create another String builder that will store the previous string in reversed order
        StringBuilder reversedString = new StringBuilder(stack.size()); // size will be stack.size()
        // while stack is not empty
        while(!stack.isEmpty()) {
            // pop each character from the stack and append to the reversed string
            reversedString.append(stack.pop()); // LIFO operation will pop each character in reverse order
        }
        // finally compare the two strings and return true if there is a match (string is a palindrome)
        return reversedString.toString().equals(stringLettersOnly.toString());
    }

}
