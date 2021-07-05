
// main class
public class LinearSearch {

    // a method that searches for a value in a given array in a linear fashion -> time complexity is O(n)
    public static int linearSearch(int[] input, int value) {
        // iterate over the array and keep incrementing the index until value is found
        for (int i = 0; i < input.length; i++) {
            // if value is found at index i in the array
            if (input[i] == value) {
                return i; // return index i
            }
        }
        // the value searched for is not in the array
        return -1;
    }

    // main method
    public static void main(String[] args) {
        // create an array of integers
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
        // call linearSearch method and print results
        System.out.println(linearSearch(intArray, -15)); // 2
        System.out.println(linearSearch(intArray, 1)); // 5
        System.out.println(linearSearch(intArray, 8888)); // -1
        System.out.println(linearSearch(intArray, -22)); // 6
    }

}
