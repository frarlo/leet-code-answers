public class Main {

    /*

    You are given an integer array nums. You are initially positioned at the array's first index,
    and each element in the array represents your maximum jump length at that position.

    Return true if you can reach the last index, or false otherwise.

    Example 1:

        Input: nums = [2,3,1,1,4]
        Output: true
        Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

    Example 2:

        Input: nums = [3,2,1,0,4]
        Output: false
        Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

    */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 55 - Jump Game *** \n");

        int[] nums = {3, 2, 1, 0, 4};

        boolean gameOutput = canJump(nums);

        if(gameOutput){
            System.out.println("You win!");
        }else{
            System.out.println("You lose...");
        }

    }

    public static boolean canJump(int[] nums){

        int maxJumps = 0;
        int i = 0;

        while (i < nums.length && i <= maxJumps){

            maxJumps = Math.max(maxJumps, nums[i] + i);
            i++;

        }

        return i == nums.length;
    }

}