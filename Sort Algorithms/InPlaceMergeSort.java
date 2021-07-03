/*

Given two sorted arrays, array1 and array2 each with n sorted values, where array1 is of size n and array2 is of size 2n where the right most n values are 0-padded,
return a single sorted array containing the values from both.

For example, array1 may contain the values [1,6,10,11] while array2 would contain the values [5,7,10,20,0,0,0,0].

Your function should return [1,5,6,7,10,10,11,20].

The process shown in 8 steps:

array1: [1,6,10,11]
array2:[5,7,10,20,0,0,0,0]

->

array1: [1,6,10,11]
array2:[5,7,10,0,0,0,0,20]

->

array1: [1,6,10,0]
array2:[5,7,10,0,0,0,11,20]

->

array1: [1,6,0,0]
array2:[5,7,10,0,0,10,11,20]

->

array1: [1,6,0,0]
array2:[5,7,0,0,10,10,11,20]

->

array1: [1,6,0,0]
array2:[5,0,0,7,10,10,11,20]

->

array1: [1,0,0,0]
array2:[5,0,6,7,10,10,11,20]

->

array1: [1,0,0,0]
array2:[0,5,6,7,10,10,11,20]

->

array1: [0,0,0,0]
array2:[1,5,6,7,10,10,11,20]

*/

import java.util.Arrays;

// MergeSort Class
public class InPlaceMergeSort {

    // a method that swaps the elements from two different arrays
    public static void swap(int[] firstArray, int firstIndex, int[] secondArray, int secondIndex) {
        int temp = firstArray[firstIndex];
        firstArray[firstIndex] = secondArray[secondIndex];
        secondArray[secondIndex] = temp;
    }

    // a method that implements a modified in-place merge sort (since lists/arrays are already sorted, recursion is not needed)
    public static int[] mergeSort(int[] leftArray, int[] rightArray) {
        // create indices (pointers) that will be point to end of each array
        int leftIndex = leftArray.length - 1; // will point to the end of the left array
        int rightIndex = leftArray.length - 1; // will point to the end of real values in the right array
        // create a resulting array that the method returns
        int[] sortedArray = rightArray; // will be the same as the right array since we already added proper padding
        int sortedIndex = rightArray.length - 1; // will point to the end of the zero padding in the right array
        // we start from the end of the arrays and keep checking each element until we reach the front of the arrays
        while (rightIndex >= 0 && leftIndex >= 0) {
            // if the element in right array is greater than the element in the left array at the given indices
            if (rightArray[rightIndex] > leftArray[leftIndex]) {
                // work backwards, from right to left in descending order so that the sorted array that is returned is ascending from left to right
                swap(rightArray, rightIndex, sortedArray, sortedIndex); // swap between right array and sorted array
                rightIndex--; // point to the next element on the left for the right
            }
            else {
                // otherwise, swap between left array and sorted array
                swap(leftArray, leftIndex, sortedArray, sortedIndex);
                leftIndex--; /// point to the next element on the left for the left array
            }
            sortedIndex--; // after swapping is done, point to the next element on the left for the sorted array
        }
        // swap any remaining elements by traversing the right array from back to front
        while (rightIndex >= 0) {
            // swap elements between the right array and the sorted array
            swap(rightArray, rightIndex, sortedArray, sortedIndex);
            rightIndex--; // point to the next element on the left for the right array
            sortedIndex--; // point to the next element on the left for the sorted array
        }
        // swap any remaining elements by traversing the left array from back to front
        while (leftIndex >= 0) {
            // swap elements between the left array and the sorted array
            swap(leftArray, leftIndex, sortedArray, sortedIndex);
            leftIndex--; // point to the next element on the left for the left array
            sortedIndex--; // point to the next element on the left for the sorted array
        }
        return sortedArray;
    }


    // main method
    public static void main(String[] args) {
        // create two arrays
        int[] arr1 = {1,6,10,11};
        int[] arr2 = {5,7,10,20,0,0,0,0};
        // call the mergeSort method and print the sorted array
        System.out.println(Arrays.toString(mergeSort(arr1, arr2))); // [1,5,6,7,10,10,11,20]
    }

}
