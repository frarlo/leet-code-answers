public class Main {

    /*

    Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according
    to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

    Note:

    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.


    Example 1:

        Input: board =
        [["5","3",".",".","7",".",".",".","."]
        ,["6",".",".","1","9","5",".",".","."]
        ,[".","9","8",".",".",".",".","6","."]
        ,["8",".",".",".","6",".",".",".","3"]
        ,["4",".",".","8",".","3",".",".","1"]
        ,["7",".",".",".","2",".",".",".","6"]
        ,[".","6",".",".",".",".","2","8","."]
        ,[".",".",".","4","1","9",".",".","5"]
        ,[".",".",".",".","8",".",".","7","9"]]

        Output: true

    Example 2:

        Input: board =
        [["8","3",".",".","7",".",".",".","."]
        ,["6",".",".","1","9","5",".",".","."]
        ,[".","9","8",".",".",".",".","6","."]
        ,["8",".",".",".","6",".",".",".","3"]
        ,["4",".",".","8",".","3",".",".","1"]
        ,["7",".",".",".","2",".",".",".","6"]
        ,[".","6",".",".",".",".","2","8","."]
        ,[".",".",".","4","1","9",".",".","5"]
        ,[".",".",".",".","8",".",".","7","9"]]

        Output: false

        Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
        Since there are two 8's in the top left 3x3 sub-box, it is invalid.

    */


    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 36 - Valid Sudoku *** \n");

        char[][] board1 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] board2 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println("Is the first board a valid Sudoku? " + isValidSudoku(board1));
        System.out.println("Is the second board a valid Sudoku? " + isValidSudoku(board2));

    }


    public static boolean isValidSudoku(char[][] board) {

        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] subgrids = new boolean[9][9];

        for(int i = 0; i < 9; i++){

            for(int j = 0; j < 9; j++){

                char currentCharacter = board[i][j];

                if(currentCharacter == '.'){
                    continue;
                }

                // Converting the char to an integer (-1 for the index):
                int currentNumber = currentCharacter - '0' - 1;

                // Calculating the index for the subgrids:
                int subgridIndex = (i / 3) * 3 + j / 3;

                // Checking if the number has been recorded in the row, column or subgrid.
                if(rows[i][currentNumber] || columns[j][currentNumber] || subgrids[subgridIndex][currentNumber]){
                    // It is not a valid Sudoku:
                    return false;
                }

                // If the executions arrives here, the number can be valid and we update each matrix:
                rows[i][currentNumber] = true;
                columns[j][currentNumber] = true;
                subgrids[subgridIndex][currentNumber] = true;

            }
        }
        // If the grid is fully traversed and its complies with Sudoku's rules return true:
        return true;
    }


}