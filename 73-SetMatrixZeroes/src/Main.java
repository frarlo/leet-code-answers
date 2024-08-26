import java.util.Arrays;

public class Main {

     /*

    Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

    You must do it in place.

    Example 1:

        Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]

        Output: [[1,0,1],[0,0,0],[1,0,1]]

    Example 2:

        Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]

        Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

    */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 73 - Set Matrix Zeroes *** \n");

        int[][] matrix1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] matrix2 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        System.out.println("Matrix -> " + Arrays.deepToString(matrix1) + " | Zeroed -> " + Arrays.deepToString(setZeroes(matrix1)));
        System.out.println("Matrix -> " + Arrays.deepToString(matrix2) + " | Zeroed -> " + Arrays.deepToString(setZeroes(matrix2)));

    }

    public static int[][] setZeroes(int[][] matrix) {

        int length = matrix.length;
        int height = matrix[0].length;

        boolean fillFirstRow = false;
        boolean fillFirstColumn = false;

        // Checking if the first row and column has any zero:
        for(int i = 0; i < length; i++){
            if(matrix[i][0] == 0){
                fillFirstRow = true;
                break;
            }
        }

        for(int j = 0; j < height; j++){
            if(matrix[0][j] == 0){
                fillFirstColumn = true;
                break;
            }
        }

        // Using the first row and column to mark zeroes:
        for(int i = 1; i < length; i++){
            for(int j = 1; j < height; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Filling with zeroes all the matrix except the first row and column:
        for(int i = 1; i < length; i++){
            for(int j = 1; j < height; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // If it is needed, we will fill with zeroes the first row and the first column:
        if(fillFirstRow){
            for(int i = 0; i < length; i++){
                matrix[i][0] = 0;
            }
        }

        if(fillFirstColumn){
            for(int j = 0; j < height; j++){
                matrix[0][j] = 0;
            }
        }

        return matrix;
    }

}