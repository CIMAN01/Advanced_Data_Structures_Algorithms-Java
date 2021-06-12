/*
*
*  Sort the following values using radix sort:
*
*  "bcdef", dbaqc, "abcde", "omadd", "bbbbb"
*
*  assume all values are in lower case
*
* */

public class Challenge3 {


    public static void main(String[] args) {

        String[] stringsArray = { "bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};

        // do radix sort
        radixSort(stringsArray, 26, 5);

        for (int i = 0; i < stringsArray.length; i++) {
            System.out.println(stringsArray[i]);
        }
    }

    public static void radixSort(String[] input, int radix, int width) {
        for (int i = width - 1; i >= 0; i--) { // modified the loop because we want to start i at the right-most position because of the way getIndex method is coded
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(String[] input, int position, int radix) {

        int numItems = input.length;

        int[] countArray = new int[radix];

        for (String value: input) {
            countArray[getIndex(position, value)]++;
        }
        // adjust the count array
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        String[] temp = new String[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getIndex(position, input[tempIndex])]] =
                    input[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }

    }

    // find the position in the counting array (find the index)
    public static int getIndex(int position, String value) {
        // translate a numeric value for a lower case character to its index in the counting array by subtracting out the character 'a'
        return value.charAt(position) - 'a'; // 'a' has an ASCII value of 97
    }

}
