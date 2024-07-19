import java.util.Arrays;

public class Main {

    /*
        Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each
        unique element appears only once. The relative order of the elements should be kept the same. Then return
        the number of unique elements in nums.

        Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

        - Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
        - Return k.

        Custom Judge:

        The judge will test your solution with the following code:

            int[] nums = [...]; // Input array
            int[] expectedNums = [...]; // The expected answer with correct length

            int k = removeDuplicates(nums); // Calls your implementation

            assert k == expectedNums.length;
            for (int i = 0; i < k; i++) {
                assert nums[i] == expectedNums[i];
        }
    */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 26 - Remove Duplicates from Sorted Array *** \n");

        int k = solution();

        System.out.println("Expected numbers: " + k);

    }

    public static int solution(){

        // Test data:
        int[] nums = {0,0,1,1,1,2,2,3,3,4};


        int i = 0;
        int k = 0;
        nums[k] = nums[i];

        for (i = 1; i < nums.length; i++){

            if(nums[k] != nums[i]){
                k++;
                nums[k] = nums[i];
            }

        }

        System.out.println(Arrays.toString(nums));

        return k + 1;
    }
}