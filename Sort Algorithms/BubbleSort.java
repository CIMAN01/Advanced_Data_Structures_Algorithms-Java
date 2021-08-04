// main class
public class BubbleSort {

    // a method that sorts an array by using bubble sort -> best time complexity: O(n) | worst time complexity: O(n^2)
    public static void sort(int[] array) {
        // iterate over the entire array
        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            // iterate over the unsorted partition of the array
            for (int i = 0; i < lastUnsortedIndex; i++) {
                // perform a swap as needed
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
        }
    }

    // a method that sorts an array by using bubble sort -> best time complexity: O(n) | worst time complexity: O(n^2)
    public static void sort2(int[] array) {
        // create a boolean condition needed for an optimization (fewer iterations needed)
        boolean isSorted;
        // iterate over the entire array
        for (int i = 0; i < array.length; i++) {
            // an optimization for when the array is already sorted or partially sorted
            isSorted = true; // true means we need fewer than n iterations
            // iterate and compare the second item with the previous item (compare every two items)
            for (int j = 1; j < array.length-i; j++) {
                // check if items are out of order and perform a swap if they are
                if(array[j] < array[j-1]) {
                    swap(array, j, j-1); // call swap method
                    isSorted = false; // update condition
                }
            }
            // optimization: if array is already sorted there is no need to iterate over the array one more time
            if (isSorted) {
                return;
            }
        }
    }

    // a method that swaps two items based on their indices 
    public static void swap(int[] array, int i, int j) {
        // if items are equal there is no need to swap
        if (i == j) {
            return;
        }
        // swap items
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // a method that prints the value of each of the elements of an array
    public static void print(int[] array) {
        System.out.println();
        // iterate over the array and print each element's value
        for (int j : array) {
            System.out.print(j + "  ");
        }
        System.out.println();
    }

    // main method
    public static void main(String[] args) {
        // create an array with some random values
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
        // call the first method that sorts the array
        sort(intArray);
        // print the entire array
        print(intArray);
        // call the second method that sorts the array
        sort2(intArray);
        // // print the entire array
        print(intArray);
    }

}
