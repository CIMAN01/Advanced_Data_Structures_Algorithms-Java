
// Binary Search is the standard search algorithm, however, as a requirement you can only use Binary Search algorithm on data that has been sorted!
// Time complexity for a binary search is O(logn) because the algorithm keeps dividing the array in half.

// main class
public class BinarySearch {

    // a method that uses an iterative version of a binary search (assumes array is sorted) -> time complexity: O(log(n)
    public static int iterativeBinarySearch(int[] input, int value) {
        // create indices for the beginning and end of the array
        int start = 0; // start at index 0
        int end = input.length; // end index will always be one greater than the last valid index
        // while we haven't reached the end of the array when searching
        while (start < end) {
            // create a midpoint partition (divide the array in half)
            int midpoint = (start + end) / 2;
            // if the midpoint happens to be the value we're search for
            if (input[midpoint] == value) {
                // * if the value does exist in the array, the search will at some point return the midpoint *
                return midpoint; // we're done with the search, return the midpoint
            }
            // otherwise we keep searching the array:
            // if the midpoint is less than the value we're searching for
            else if (input[midpoint] < value) {
                start = midpoint + 1; // search the right half of the array
            }
            // if the midpoint is greater than the value we're searching for
            else {
                // search the left half of the array instead
                end = midpoint; // midpoint is always one greater than the end of the partition
            }
        }
        // if we have searched the entire array and come up empty, we return a -1
        return -1;
    }

    // *** take the loop in the iterative version and change it to a recursive method ***

    // a method that uses a recursive implementation of a binary search -> less efficient than the iterative version due to the overhead involved with method calls
    public static int recursiveBinarySearch(int[] input, int value) { // this method takes in the entire array and a value
        // call the second recursive method that also takes in a start and end point
        return recursiveBinarySearch(input, 0, input.length, value);
    }

    // a method that uses a recursive version of a binary search (assumes array is sorted) -> iterative version preferred
    public static int recursiveBinarySearch(int[] input, int start, int end, int value) {
        // breaking condition: we have search the entire array and come up empty so a -1 is returned
        if (start >= end) { // same condition as line 14, but instead of continuing we're stopping
            return -1;
        }
        // create a midpoint partition (divide the array in half)
        int midpoint = (start + end) / 2;
        // if the midpoint happens to be the value we're search for
        if (input[midpoint] == value) {
            return midpoint; // we're done with the search, return the midpoint
        }
        // otherwise we keep searching the array:
        // if the midpoint is less than the value we're searching for
        else if (input[midpoint] < value) {
            // search the right half of the array
            return recursiveBinarySearch(input, midpoint + 1, end, value);
        }
        // if the midpoint is greater than the value we're searching for
        else {
            // search the left half of the array instead
            return recursiveBinarySearch(input, start, midpoint, value);
        }
    }

    // main method
    public static void main(String[] args) {
        // create an array of integers
        int[] intArray = { -22, -15, 1, 7, 20, 35, 55 };
        // call a method that uses an iterative binary search and print the result(s)
        System.out.println(iterativeBinarySearch(intArray, -15)); // 1
        System.out.println(iterativeBinarySearch(intArray, 35)); // 5
        System.out.println(iterativeBinarySearch(intArray, 8888)); // -1
        System.out.println(iterativeBinarySearch(intArray, 1)); // 2
        // call a method that uses a recursive binary search and print the result(s)
        System.out.println(recursiveBinarySearch(intArray, -15)); // 1
        System.out.println(recursiveBinarySearch(intArray, 35)); // 5
        System.out.println(recursiveBinarySearch(intArray, 8888)); // -1
        System.out.println(recursiveBinarySearch(intArray, 1)); // 2
    }

}
