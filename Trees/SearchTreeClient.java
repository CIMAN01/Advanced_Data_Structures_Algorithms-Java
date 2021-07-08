// This program uses the SearchTree class to construct a binary search tree of strings and a binary search tree of integers and printing out each.

import java.util.*;

// Client
public class SearchTreeClient {

    // main method
    public static void main(String[] args) {
        // create a new Scanner
        Scanner console = new Scanner(System.in);
        // create a new SearchTree node that holds String values
        SearchTree<String> names = new SearchTree<>();
        // message client to quit or continue
        System.out.print("Name (blank to quit)? ");
        String name = console.nextLine();
        // to exit loop a blank must be entered via the command
        while (name.length() > 0) {
            names.add(name);
            System.out.print("Name (blank to quit)? ");
            name = console.nextLine();
        }
        // create a new line
        System.out.println();
        System.out.println("Alphabetized list:");
        // print
        names.print();
        System.out.println();
        // create a new SearchTree node that holds integers
        SearchTree<Integer> numbers = new SearchTree<>();
        // message client to quit or continue
        System.out.print("Next int (0 to quit)? ");
        // process next number
        int number = console.nextInt();
        // to exit loop a 0 must be entered via the command
        while (number != 0) {
            numbers.add(number);
            System.out.print("Next int (0 to quit)? ");
            number = console.nextInt();
        }
        // create a new line
        System.out.println();
        System.out.println("Sorted list:");
        // print
        numbers.print();
    }

}
