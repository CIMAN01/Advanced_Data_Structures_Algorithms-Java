

public class BubbleSort {

    public static void main(String[] args) {

        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0;
             lastUnsortedIndex--) {
            //
            for (int i = 0; i < lastUnsortedIndex; i++) {
                //
                if (intArray[i] > intArray[i + 1]) {
                    swap(intArray, i, i + 1);
                }
            }
        }

        // print the array
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }


    }

    // swap method
    public static void swap(int[] array, int i, int j) {
        // base case
        if (i == j) {
            return;
        }
        // swap
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
