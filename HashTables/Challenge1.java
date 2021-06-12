

public class Challenge1 {

    public static void main(String[] args) {

        int[] nums = new int[10];
        int[] numsToAdd = { 59382, 43, 6894, 500, 99, -58 };
        for (int i = 0; i < numsToAdd.length; i++) {
            nums[hash(numsToAdd[i])] = numsToAdd[i];
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    // Challenge: complete the hashing function below

    // hashing function (method)
    public static int hash(int value) {
        // mod by the length of the array to avoid out-of-bounds error
        return Math.abs(value % 10);
    }
}
