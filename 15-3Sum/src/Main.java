import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    /*
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
    and j != k, and nums[i] + nums[j] + nums[k] == 0.

    Notice that the solution set must not contain duplicate triplets.

    Example 1:

        Input: nums = [-1,0,1,2,-1,-4]
        Output: [[-1,-1,2],[-1,0,1]]

        Explanation:
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.

        The distinct triplets are [-1,0,1] and [-1,-1,2].
        Notice that the order of the output and the order of the triplets does not matter.

    Example 2:

        Input: nums = [0,1,1]
        Output: []

        Explanation: The only possible triplet does not sum up to 0.

    Example 3:

        Input: nums = [0,0,0]
        Output: [[0,0,0]]

        Explanation: The only possible triplet sums up to 0.

    */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 15 - 3Sum *** \\n");

        int[] nums1 = {1, 0, 1, 2, -1, -4};
        int[] nums2 = {-2, 0, 1, 1, 2};
        int[] nums3 = {0, 0, 0};

        System.out.println("Nums: " + Arrays.toString(nums1) + " | Output: " + threeSum(nums1));
        System.out.println("Nums: " + Arrays.toString(nums2) + " | Output: " + threeSum(nums2));
        System.out.println("Nums: " + Arrays.toString(nums3) + " | Output: " + threeSum(nums3));

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3){
            return new ArrayList<>();
        }

        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i + 2 < nums.length; ++i) {

            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {

                int sum = nums[i] + nums[start] + nums[end];

                if (sum == 0) {

                    answer.add(Arrays.asList(nums[i], nums[start++], nums[end--]));

                    while (start < end && nums[start] == nums[start - 1]){
                        start++;
                    }
                    while (start < end && nums[end] == nums[end + 1]){
                        end--;
                    }

                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return answer;
    }

}
