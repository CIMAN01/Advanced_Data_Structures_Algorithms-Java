/*
*
*  Change insertion sort so that it uses recursion
*
* */

public class Challenge2 {


    public static void main(String[] args) {

        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        // the recursive calls complete in the reverse order that they were called (the first call to return is the one with 2 items)
        insertionSort(intArray, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }

    }

    // each call to the method grows the sorted partition by one
    public static void insertionSort(int[] input, int numItems) {
        // our breaking condition: when we have one item by definition that one item is sorted
        if(numItems < 2) {
            return;
        }
        // when we have 2 or more items we have to continue sorting
        insertionSort(input, numItems - 1); // same input array but with one less item (sort all items minus the last one)

        // after the 6 items have been sorted recursively at this point, we now move on to sort the last item (7th item):

        int newElement = input[numItems - 1]; // 7th item is at the 6th index (numItems-1)

        int i; // declared here because needed outside for loop

        // look for insertion point here (as long as element is greater than newElement, keep looking for the insertion point
        // because we want to find the first element that's less than or equal to the one we want to insert)
        for (i = numItems - 1; i > 0 && input[i - 1] > newElement; i--) { // only doing one iteration
            input[i] = input[i - 1]; // shifting elements up to make room for the insertion
        }

        input[i] = newElement; // i will be the insertion point for the new element

    }

}
