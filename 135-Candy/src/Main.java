import java.util.Arrays;

public class Main {

    /*

    There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
    You are giving candies to these children subjected to the following requirements:

    - Each child must have at least one candy.
    - Children with a higher rating get more candies than their neighbors.
    - Return the minimum number of candies you need to have to distribute the candies to the children.

    Example 1:

        Input: ratings = [1,0,2]
        Output: 5

        Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

    Example 2:

        Input: ratings = [1,2,2]
        Output: 4

        Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
        The third child gets 1 candy because it satisfies the above two conditions.

     */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 135 - Candy *** \n");

        // Four test cases:
        int[] ratings1 = {1, 0, 2};
        int[] ratings2 = {1, 2, 2};
        int[] ratings3 = {1, 2, 87, 87, 87, 2, 1};
        int[] ratings4 = {1,3,2,2,1};

        int solution1 = candy(ratings1);
        int solution2 = candy(ratings2);
        int solution3 = candy(ratings3);
        int solution4 = candy(ratings4);

        System.out.println("Input: " + Arrays.toString(ratings1) + " ===> Candies: " + solution1);
        System.out.println("Input: " + Arrays.toString(ratings2) + " ===> Candies: " + solution2);
        System.out.println("Input: " + Arrays.toString(ratings3) + " ===> Candies: " + solution3);
        System.out.println("Input: " + Arrays.toString(ratings4) + " ===> Candies: " + solution4);

    }

    public static int candy(int[] ratings){

        int length = ratings.length;

        if(length == 0){
            return 0;
        }

        // Candies array init with one candy for each child:
        int[] candies = new int[length];
        Arrays.fill(candies,1);

        // First loop to check from LEFT to RIGHT:
        for (int i = 1; i < length; i++){

            // If the rating is higher that its left neighbour adds one extra candy.
            if(ratings[i] > ratings[i - 1]){
                candies[i] = candies[i - 1] + 1;
            }

        }

        // Second loop to check from RIGHT to LEFT (starting at the penultimate index, hence the length -2).
        for (int i = length -2; i >= 0; i--){

            // If the rating is higher than its right neighbour adds one extra candy.
            if(ratings[i] > ratings[i + 1]){
                // Establishes that each child has more candies that its right neighbour if there is a higher rating.
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }

        }

        // Adding all the candies to our variable:
        int totalCandies = 0;
        for (int candy : candies){
            totalCandies = totalCandies + candy;
        }

        return totalCandies;

    }

}