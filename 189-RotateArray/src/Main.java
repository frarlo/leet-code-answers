import java.util.Arrays;

public class Main {

    /*

    Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

    Example 1:

    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]
    Example 2:

    Input: nums = [-1,-100,3,99], k = 2
    Output: [3,99,-1,-100]
    Explanation:
    rotate 1 steps to the right: [99,-1,-100,3]
    rotate 2 steps to the right: [3,99,-1,-100]

     */

    public static void main(String[] args) {
        System.out.println("*** Solution for LeetCode problem 189 - Rotate Array *** \n");

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        solution(nums, k);

    }

    public static void solution(int[] nums, int k){

        int length = nums.length;
        int[] solution = new int[length];

        // Creating a new array with the new order:
        for(int i = 0; i < length; i++){

            // Updating the array in the index resulting of the module between i + k and the array's length:
            solution[(i + k) % length] = nums[i];

        }

        // Copying the new array to the original one:
        for(int i = 0; i < length; i++){
            nums[i] = solution[i];
        }

        System.out.println(Arrays.toString(nums));
    }

}

