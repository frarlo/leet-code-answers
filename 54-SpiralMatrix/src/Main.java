import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

     /*

    Given an m x n matrix, return all elements of the matrix in spiral order.

    Example 1:

        Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]

        Output: [1,2,3,6,9,8,7,4,5]

    Example 2:

        Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]

        Output: [1,2,3,4,8,12,11,10,9,5,6,7]

    */


    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 54 - Spiral Matrix *** \n");

        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        System.out.println("The matrix " + Arrays.deepToString(matrix1) + " has the following spiral order: " + spiralOrder(matrix1));
        System.out.println("The matrix " + Arrays.deepToString(matrix2)+ " has the following spiral order: " + spiralOrder(matrix2));

    }


    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> integerList = new ArrayList<>();

        // Start and end of both rows and columns:
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int columnStart = 0;
        int columnEnd = matrix[0].length - 1;

        // While the row start is lesser or equal to its end and the same for the columns...
        while(rowStart <= rowEnd && columnStart <= columnEnd){

            // Left to right:
            for(int j = columnStart; j <= columnEnd; j++){
                integerList.add(matrix[rowStart][j]);
            }

            rowStart++;

            // Up to bottom:
            for(int i = rowStart; i <= rowEnd; i++){
                integerList.add(matrix[i][columnEnd]);
            }

            columnEnd--;

            // Checking the rows to traverse left:
            if(rowStart <= rowEnd){

                for(int j = columnEnd; j >= columnStart; j--){
                    integerList.add(matrix[rowEnd][j]);
                }

            }

            rowEnd--;

            // Checking the columns to traverse up:
            if(columnStart <= columnEnd){

                for(int i = rowEnd; i >= rowStart; i--){
                    integerList.add(matrix[i][columnStart]);
                }

            }

            columnStart++;

        }

        return integerList;
    }

}


