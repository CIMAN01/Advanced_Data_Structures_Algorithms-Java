/* Quick Sort Implementing
*
* Divide and Conquer algorithm
*
* Recursive algorithm
*
* Uses a pivot element to partition the array into two parts
*
* Elements < pivot to its left and elements > pivot to its right
*
* Pivot will then be in its correct sorted position
*
* Quicksort is an in-place algorithm (unlike the merge sort), and an unstable algorithm (relative positioning of duplicate items will not be preserved)
*
* Average Time Complexity: O(n log n) - base 2
*
*
* */

// main class
public class QuickSort {

    // main method
    public static void main(String[] args) {
        // create an array with random values
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
        // call the method for sorting the array
        quickSort(intArray, 0, intArray.length);
        // print the results by iterating over the changed array
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    // quickSort method
    public static void quickSort(int[] input, int start, int end) {
        // less than 2 because we're done once each array consists of only one element (meaning we have a sorted array at this stage)
        if (end - start < 2) {
            return;
        }
        // store the index returned from partition method
        int pivotIndex = partition(input, start, end);
        // use recursion to sort the left sub-array
        quickSort(input, start, pivotIndex); // this recursive call is not going to return until entire left array (sub-array) has been quick-sorted
        // use recursion to sort the right sub-array
        quickSort(input, pivotIndex + 1, end); // this recursive call is not going to return until entire right array (sub-array) has been quick-sorted
    }

    // partition method
    public static int partition(int[] input, int start, int end) { // end will always be one greater than the last index of the array
        // this is using the first element as the pivot
        int pivot = input[start]; // not necessarily index 0
        // assign start, end to i and j, respectively
        int i = start;
        int j = end;
        // while i hasn't crossed j
        while (i < j) {
            // NOTE: empty loop body -> only using loop to decrement j until we either find an element that is less than the pivot or j crosses i
            while (i < j && input[--j] >= pivot); // must use prefix --j in order to be in the proper position (i.e. avoid index of out bounds exception)
            // make sure we didn't fall out of the above loop because i crossed j
            if (i < j) {
                // if i is still less than j, move j-th element into i-th position (move towards the front of the array because j is less than the pivot index)
                input[i] = input[j];
            }
            // NOTE: empty loop body -> same as above but now we move all the element greater than the pivot to the right of it
            while (i < j && input[++i] <= pivot); // must use prefix ++i in order to be in the proper position (i.e. must come after the starting pivot and later because we've already handled position i)
            // make sure we didn't fall out of the above loop because i crossed j
            if (i < j) {
                // if i is still less than j, move i-th element into j-th position (move towards the back of the array because i is greater than the pivot index)
                input[j] = input[i]; // safe to assign/overwrite as we're not losing any data due to a previous assignment taking place during the previous loop (we're alternating between i and j)
            }
        }
        // after the loop finishes (where i has crossed j) we've finished moving the elements smaller than the pivot to the left sub-array and the elements larger than the pivot
        // to the right sub-array, and the value of j will be the index where we want to insert the pivot
        input[j] = pivot;
        // finally, return j which will be the pivotIndex needed for the quickSort method
        return j;
    }

}
