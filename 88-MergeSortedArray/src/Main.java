import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 88 - Merge Sorted Array *** \n");

        solution();
    }

    public static void solution(){

        // Example 1 data:
        int[] nums1Array = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2Array = {2, 5, 6};
        int n = 3;

        for(int i = 0; i < n; i = i + 1){
            nums1Array[m + i]  = nums2Array[i];
        }

        Arrays.sort(nums1Array);

        System.out.println(Arrays.toString(nums1Array));

    }

}