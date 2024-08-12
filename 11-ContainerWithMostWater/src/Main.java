import java.util.Arrays;

public class Main {

    /*

    You are given an integer array height of length n. There are n vertical lines drawn such that
    the two endpoints of the ith line are (i, 0) and (i, height[i]).

    Find two lines that together with the x-axis form a container, such that the container contains the most water.

    Return the maximum amount of water a container can store.

    Notice that you may not slant the container.

    Example 1:

        Input: height = [1,8,6,2,5,4,8,3,7]
        Output: 49
        Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
        In this case, the max area of water (blue section) the container can contain is 49.

    Example 2:

        Input: height = [1,1]
        Output: 1

     */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 11 - Container With Most Water *** \\n");

        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height2 = {1, 1};

        System.out.println("Maximum water area in " + Arrays.toString(height1) + " is '"
                + maxArea(height1) + "' ");

        System.out.println("Maximum water area in " + Arrays.toString(height2) + " is '"
                + maxArea(height2) + "' ");

    }

    public static int maxArea(int[] height){

        int start = 0;
        int end = height.length - 1;
        int answer = 0;

        while(start < end){

            int minimumHeight = Math.min(height[start], height[end]);

            answer = Math.max(answer, minimumHeight * (end - start));

            if(height[start] < height[end]) {
                start++;
            }else{
                end--;
            }

        }

        return answer;
    }


}