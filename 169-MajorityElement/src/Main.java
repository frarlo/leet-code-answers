public class Main {

    /*

    Given an array nums of size n, return the majority element.

    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

    Example 1:

    Input: nums = [3,2,3]
    Output: 3
    Example 2:

    Input: nums = [2,2,1,1,1,2,2]
    Output: 2

     */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 169 - Majority Element *** \n");

        int solution = solution();

        System.out.println("Expected majority element: " + solution);

    }

    public static int solution(){

        // Input 1:
        // int[] nums = {3, 2, 3};
        // Input 2:
        int[] nums = {3, 3, 4};

        // Using Boyer-Moore Voting Algorithm:
        int count = 0;
        Integer candidate = null;

        for (int n : nums){

            if(count == 0){
                candidate = n;
            }
            if(n == candidate){
                count++;
            }else{
                count--;
            }

        }

        return candidate;

    }


}