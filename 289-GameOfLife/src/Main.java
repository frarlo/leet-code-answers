import java.util.Arrays;

public class Main {

    /*

    According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton
    devised by the British mathematician John Horton Conway in 1970."

    The board is made up of an m x n grid of cells, where each cell has an initial state:
    live (represented by a 1) or dead (represented by a 0).

    Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following
    four rules (taken from the above Wikipedia article):

    1. Any live cell with fewer than two live neighbors dies as if caused by under-population.

    2. Any live cell with two or three live neighbors lives on to the next generation.

    3. Any live cell with more than three live neighbors dies, as if by over-population.

    4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

    The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.


    Example 1:

        Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]

        Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

    Example 2:

        Input: board = [[1,1],[1,0]]

        Output: [[1,1],[1,1]]

    */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 289 - The Game of Life *** \n");

        int[][] board1 = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        int[][] board2 = {
                {1, 1},
                {1, 0}
        };

        System.out.println("Board -> " + Arrays.deepToString(board1) + " | Solution -> " + Arrays.deepToString(gameOfLife(board1)));
        System.out.println("Board -> " + Arrays.deepToString(board2) + " | Solution -> " + Arrays.deepToString(gameOfLife(board2)));

    }

    public static int[][] gameOfLife(int[][] board) {

        int length = board.length;
        int height = board[0].length;

        for(int i = 0; i < length; i++){
            for(int j = 0; j < height; j++){

                int lives = neighboursLives(board, length, height, i, j);

                if(board[i][j] == 1 && lives >= 2 && lives <= 3){
                    board[i][j] = 3;
                }
                if(board[i][j] == 0 && lives == 3){
                    board[i][j] = 2;
                }
            }
        }

        for(int i = 0; i < length; i++){
            for(int j = 0; j < height; j++){
                board[i][j] >>= 1;
            }
        }

        return board;
    }


    public static int neighboursLives(int[][] board, int length, int height, int i, int j){

        int lives = 0;

        for(int row = Math.max(i - 1, 0); row <= Math.min(i + 1, length - 1); row++){
            for(int col = Math.max(j - 1, 0); col <= Math.min(j + 1, height - 1); col++){
                lives += board[row][col] & 1;
            }
        }

        lives -= board[i][j] & 1;

        return lives;
    }
}