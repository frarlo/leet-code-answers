import java.util.Arrays;

public class Main {

    /*

    Given n non-negative integers representing an elevation map where the width of each bar is 1,
    compute how much water it can trap after raining.

    Example 1:

        Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
        Output: 6

        Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
        In this case, 6 units of rain water (blue section) are being trapped.

    Example 2:

    Input: height = [4,2,0,3,2,5]
    Output: 9

    */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 42 - Trapping Rain Water *** \n");

        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height2 = {4, 2, 0, 3, 2, 5};

        int water1 = trap(height1);
        int water2 = trap(height2);

        System.out.println("For the height: " + Arrays.toString(height1) + "\nTrapped Water: " + water1);

        System.out.println("For the height: " + Arrays.toString(height2) + "\nTrapped Water: " + water2);


    }

    public static int trap(int[] height){

        int heightLength = height.length;
        int water = 0;

        // We create two arrays to store both left and right heights:
        int[] leftHeight = new int[heightLength];
        int[] rightHeight = new int[heightLength];

        // The first step is finding the maximum left height for each index: [START ---> END]
        leftHeight[0] = height[0];
        for(int i = 1; i < heightLength; i++){
            leftHeight[i] = Math.max(leftHeight[i - 1], height[i]);
        }

        // The second step is finding the maximum right height for each index: [END <--- START]
        rightHeight[heightLength - 1] = height[heightLength - 1];
        for(int i = heightLength - 2; i >= 0; i--){
            rightHeight[i] = Math.max(rightHeight[i + 1], height[i]);
        }

        /* Final step. Calculate the water as the minimum value between both sides [left & right] and then
        subtract the actual height in every index: */
        for(int i = 0; i < heightLength; i++){
            water += Math.min(leftHeight[i], rightHeight[i]) - height[i];
        }

        return water;

    }


}