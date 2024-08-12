import java.util.Arrays;

public class Main {

    /*
    Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
    find two numbers such that they add up to a specific target number. Let these two numbers be
    numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

    Return the indices of the two numbers, index1 and index2, added by one as an integer array
    [index1, index2] of length 2.

    The tests are generated such that there is exactly one solution. You may not use the same element twice.

    Your solution must use only constant extra space.

    Example 1:

        Input: numbers = [2,7,11,15], target = 9
        Output: [1,2]
        Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

    Example 2:

        Input: numbers = [2,3,4], target = 6
        Output: [1,3]
        Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

    Example 3:

        Input: numbers = [-1,0], target = -1
        Output: [1,2]
        Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2]

    */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 167 - Two Sum II - Input Array Sorted *** \\n");

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] nums2 = {2, 3, 4};
        int target2 = 6;
        int[] nums3 = {-1, 0};
        int target3 = -1;

        System.out.println("Numbers " + Arrays.toString(nums1) + " and target '" + target1 +"' \n" +
                "Indexes needed to implement the sum: " + Arrays.toString(twoSum(nums1,target1)));

        System.out.println("Numbers " + Arrays.toString(nums2) + " and target '" + target2 +"' \n" +
                "Indexes needed to implement the sum: " + Arrays.toString(twoSum(nums2,target2)));

        System.out.println("Numbers " + Arrays.toString(nums3) + " and target '" + target3 +"' \n" +
                "Indexes needed to implement the sum: " + Arrays.toString(twoSum(nums3,target3)));


    }

    public static int[] twoSum(int[] numbers, int target) {

        int start = 0;
        int end = numbers.length - 1;
        int[] answer = new int[2];

        while(start <= end){

            if(numbers[start] + numbers[end] == target){

                answer[0] = start + 1;
                answer[1] = end + 1;
                return answer;

            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                end--;
            }

        }

        return answer;
    }

}