import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /*

    Given an array of integers nums and an integer target, return indices of the two numbers
    such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.

    Example 1:

        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]

        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    Example 2:

        Input: nums = [3,2,4], target = 6
        Output: [1,2]

    Example 3:

        Input: nums = [3,3], target = 6
        Output: [0,1]

    */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 1 - Two Sum *** \n");

        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {3, 2, 4};
        int[] nums3 = {3, 3};
        int[] nums4 = {3, 2, 3};

        System.out.println("Array: " + Arrays.toString(nums1) + " | Target: 9 | Sum indexes are: " +
                Arrays.toString(twoSum(nums1, 9)));

        System.out.println("Array: " + Arrays.toString(nums2) + " | Target: 6 | Sum indexes are: " +
                Arrays.toString(twoSum(nums2, 6)));

        System.out.println("Array: " + Arrays.toString(nums3) + " | Target: 6 | Sum indexes are: " +
                Arrays.toString(twoSum(nums3, 6)));

        System.out.println("Array: " + Arrays.toString(nums4) + " | Target: 6 | Sum indexes are: " +
                Arrays.toString(twoSum(nums4, 6)));

    }

    public static int[] twoSum(int[] nums, int target) {

        int[] answer = new int[2];

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int value = nums[i];

            if(hashMap.containsKey(target - value)){
                answer[0] = hashMap.get(target - value);
                answer[1] = i;
            }

            hashMap.put(value, i);

        }

        return answer;
    }

}