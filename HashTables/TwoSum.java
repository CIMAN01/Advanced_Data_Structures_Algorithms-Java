/*

Given an array of integers nums and an integer target, return indices of the two numbers such that
they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1]

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

*/

import java.util.Arrays;
import java.util.HashMap;


public class TwoSum {

    // brute-force:

    // a method that finds two elements that add up to a target value (time complexity: O(n^2) )
    public static int[] twoSum(int[] nums, int target) {
        // create an array that holds two values
        int[] twoSumArr = new int[2];
        // outer loop
        for (int i = 0; i <= nums.length; i++) {
            // inner loop
            for (int j = i + 1; j < nums.length; j++) {
                // check if indices match the target value
                if(nums[i] + nums[j] == target) {
//                    twoSumArr[0] = i;
//                    twoSumArr[1] = j;
                    twoSumArr = new int[] {i, j};
                }
            }
        }
        return twoSumArr; // if output is [0, 0] it means we don't find anything
    }


    // a method using a HashMap which have constant look-up times -> O(n) time/space complexity
    public static int[] twoSum2(int[] nums, int target) {
        // create a new hashmap where key -> nums[i] element and value -> index i
        HashMap<Integer, Integer> hashmap = new HashMap<>(); 
        // iterate over the array (only one loop needed)
        for (int i = 0; i < nums.length; i++) {
            // find the complement of each number
            int complement = target - nums[i]; // nums[i] + nums[i+1] = target -> nums[i+1] = target - nums[i]
            // if the complement already exists as a key in the hashmap
            if (hashmap.containsKey(complement)) {
                // return the corresponding value (which is going to be an index alongside the current index
                return new int[]{hashmap.get(complement), i}; // the sum of the two numbers at those indices will add up to the target
            }
            // if it does not exist, store the current number along with the current index in the hashmap
            hashmap.put(nums[i], i);
        }
        // if a solution is not found, return an empty array
        return new int[] {};
    }


    // main method
    public static void main(String[] args) {
        int[] array1 = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(array1, 9))); // [0, 1]
        System.out.println(Arrays.toString(twoSum2(array1, 9))); // [0, 1]
        int[] array2 = {3, 2, 4};
        System.out.println(Arrays.toString(twoSum(array2, 6))); // [1, 2]
        System.out.println(Arrays.toString(twoSum2(array2, 6))); // [1, 2]
        int[] array3 = {3, 3};
        System.out.println(Arrays.toString(twoSum(array3, 6))); // [0, 1]
        System.out.println(Arrays.toString(twoSum2(array3, 6))); // [0, 1]
    }

}
