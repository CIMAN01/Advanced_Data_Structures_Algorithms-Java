/* Fibonacci sequence */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// main class
public class Fibonacci {

    // a method that generates the fibonacci sequence
    public static List<Integer> fibonacciGenerator(int n) {
        // create a new Arraylist
        List<Integer> arrList = new ArrayList<>();
        // if n only has one value
        if (n==1) {
            // create an array with only one element with a value of 0 only
            arrList.add(0);
        }
        // or, if n only has two values
        else if (n==2) {
            // create an array with only two elements with values of 0 and 1 only
            arrList.add(0);
            arrList.add(1);
        }
        // but, if n is larger than two values
        else {
            // create the base array
            arrList.add(0);
            arrList.add(1);
            // as long as there are more numbers to process
            for (int i = 2; i < n; i++) {
                // combine the values of the previous two indices and add it to the array
                arrList.add(arrList.get(arrList.size()-1) + arrList.get(arrList.size()-2));
            }
        }
        return arrList;
    }

    // generate fibonacci sequence recursively
    public static int fibonacciGeneratorR(int n) {
        // use base case for n == 0 or n == 1
        if (n <= 1) {
            return n;
        }
        // use recursion for n larger than 1
        return fibonacciGeneratorR(n-1) + fibonacciGeneratorR(n-2); // recursive call
    }

    // a method that calls the fibonacciGeneratorR method to generate the fibonacci series and then put it inside an array
    public static int[] fibonacciArrayGenerator(int n) {
        // create a new empty array of length n
        int[] array = new int[n];
        // iterate up to n-th value
        for (int i = 0; i < n; i++) {
            // add each part of the sequence to i-th index in the array
            array[i] = fibonacciGeneratorR(i);
        }
        return array; // the array holds the entire sequence
    }

    // main method
    public static void main(String[] args) {
        // calling a a method that generates the fibonacci sequence by implementing an ArrayList
        System.out.println(fibonacciGenerator(5)); // [0, 1, 1, 2, 3]
        // calling a method that generates the fibonacci sequence recursively, and then prints the resulting value
        System.out.println(fibonacciGeneratorR(5)); // 5
        // calling a method that generates the fibonacci sequence recursively, but prints an array holding the values
        System.out.println(Arrays.toString(fibonacciArrayGenerator(5))); // [0, 1, 1, 2, 3]
    }

}
