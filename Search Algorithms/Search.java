
// main class
public class Search {

    // Binary Search -> O(log(n)):
    public static int binarySearch(int[] arr, int low, int high, int key) {
        // breaking condition
        if (low == high) { // lower index equals higher index
            // check for a match
            if (key == arr[low]) { // or key == a[h]
                // return the index where the element equals the key value
                return low; // or return h if key == a[h]
            }
            // here we have exhausted our search and come up empty (key doesn't exist) and so we return a -1
            else {
                return -1;
            }
        }
        // create a variable for mid
        int mid = (low + high) / 2; // (must use parentheses around l+h)
        // search the middle of the array
        if (key == arr[mid]) {
            return mid;
        } // search upper right side of the array
        else if (key > arr[mid]) {
            return binarySearch(arr, mid+1, high, key);
        } // search lower left side of the array
        else { // key < a[mid]
            return binarySearch(arr, low, mid-1, key);
        }
    }

    // main method
    public static void main(String[] args) {
        int[] a = {11, 19, 24, 34, 55, 65, 71, 83, 91};
        int index = binarySearch(a, 0, 8, 100);
        System.out.println("index: " + index);
    }

}

