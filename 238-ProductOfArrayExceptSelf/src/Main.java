import java.util.Arrays;

public class Main {

    /*

    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

    You must write an algorithm that runs in O(n) time and without using the division operation.

    Example 1:

        Input: nums = [1,2,3,4]
        Output: [24,12,8,6]

    Example 2:

        Input: nums = [-1,1,0,-3,3]
        Output: [0,0,9,0,0]

    */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 238 - Product of an Array except self *** \n");

        int[] nums = {1, 2, 3, 4};

        System.out.println("Original Array: " + Arrays.toString(nums));

        int[] solution = productExceptSelf(nums);

        System.out.println("Solution Array: " + Arrays.toString(solution));

    }

    public static int[] productExceptSelf(int[] nums){

        int length = nums.length;

        int[] solution = new int[length];
        solution[0] = 1;

        // First loop to store the product of the elements at the left of each index:
        for (int i = 1; i < length; i++){
            solution[i] = solution[i - 1] * nums[i - 1];
        }

        int suffix = 1;
        /* Second loop to iterate backwards while multiplying the value of each index with the suffix, which
        is updated in each iteration of the loop with its value multiplied with the original value in the index */
        for (int i = length - 1; i >= 0; i--){
            solution[i] = solution[i] * suffix;
            suffix = suffix * nums[i];
        }

        return solution;
    }


}