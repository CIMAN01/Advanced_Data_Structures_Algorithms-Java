// main class
public class InsertionSort {

    // a method for sorting an array in ascending order
    public static void sort(int[] array) {
        // iterate over the array starting at second element
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
            // store the current item
            int newElement = array[firstUnsortedIndex];
            // create variable i needed outside loop
            int i;
            // inner loop that shift items to the right
            for (i = firstUnsortedIndex; i > 0 && array[i - 1] > newElement; i--) {
                array[i] = array[i - 1];
            }
            array[i] = newElement; // replace array element
        }
        // print the sorted array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }

    // a method for sorting an array in ascending order
    public static void sort2(int[] array) {
        // iterate over the array starting at the second element (the first element will always be the beginning of the sorted partition)
        for (int i = 1; i < array.length; i++) {
            // store the current element
            int current = array[i];
            // create j and set it to i minus one
            int j = i-1;
            // keep comparing the elements as long as they are not in the proper order
            while (j >= 0 && array[j] > current) {
                array[j+1] = array[j]; // shift larger elements to the right (copying)
                j--; // decrement j
            }
            array[j+1] = current; // place the current element in its proper place in the array
        }
        // print the sorted array
        for (int j : array) {
            System.out.print(j + "  ");
        }
    }

    // main method
    public static void main(String[] args) {
        // create an array
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
        // call the insertion sort method(s) that prints the results
        sort(intArray);
        System.out.println();
        sort2(intArray);
    }

}
