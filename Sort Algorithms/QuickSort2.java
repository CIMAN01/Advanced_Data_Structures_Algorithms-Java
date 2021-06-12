/* QuickSort as demonstrated by HackerRank's Cracking The Coding Interview Tutorial with Gayle Laakmann McDowel */

public class QuickSort2 {

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    public static void quicksort(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot);
        quicksort(array, left, index - 1);
        quicksort(array, index, right);

    }

    public static int partition(int[] array, int left, int right, int pivot) {
        // while we're not yet done going through the whole array
        while (left <= right) {
            // find element on left that should be on right
            while (array[left] < pivot) {
                left++;
            }
            // find element on right that should be on left
            while (array[right] > pivot) {
                right--;
            }
            // swap elements, and move left and right indexes
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left; // left is the partition point
    }

    // main driver
    public static void main(String[] args) {
        // create an array with random values
        int[] intArray = { 15, 3, 2, 1, 9, 5, 7, 8, 6 };
        // call the method for sorting the array
        quicksort(intArray);
        // print the results by iterating over the changed array
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

}