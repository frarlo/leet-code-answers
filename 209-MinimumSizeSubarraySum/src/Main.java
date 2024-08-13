import java.util.Arrays;

public class Main {

    /*

    Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray
    whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

    Example 1:

        Input: target = 7, nums = [2,3,1,2,4,3]
        Output: 2

        Explanation: The subarray [4,3] has the minimal length under the problem constraint.

    Example 2:

        Input: target = 4, nums = [1,4,4]
        Output: 1

    Example 3:

        Input: target = 11, nums = [1,1,1,1,1,1,1,1]
        Output: 0

     */


    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 209 - Minimum Size Subarray Sum *** \\n");

        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int target1 = 7;
        int[] nums2 = {1, 4, 4};
        int target2 = 4;
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        int target3 = 11;
        int[] nums4 = {1, 2, 3, 4, 5};
        int target4 = 11;

        System.out.println("Nums: " + Arrays.toString(nums1) + " | Output: " + minSubArrayLen(target1, nums1));
        System.out.println("Nums: " + Arrays.toString(nums2) + " | Output: " + minSubArrayLen(target2, nums2));
        System.out.println("Nums: " + Arrays.toString(nums3) + " | Output: " + minSubArrayLen(target3, nums3));
        System.out.println("Nums: " + Arrays.toString(nums4) + " | Output: " + minSubArrayLen(target4, nums4));


    }

    public static int minSubArrayLen(int target, int[] nums) {

        int length = nums.length;
        int answer = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;

        for(int end = 0; end < length; end++){

            sum += nums[end];

            while(sum >= target){

                answer = Math.min(answer, end - start + 1);
                sum -= nums[start];
                start++;
            }

        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}

