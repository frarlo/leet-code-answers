public class Main {

    /*

    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
    (you may want to display this pattern in a fixed font for better legibility)

    P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"

    Write the code that will take a string and make this conversion given a number of rows:

    string convert(string s, int numRows);

    Example 1:

        Input: s = "PAYPALISHIRING", numRows = 3
        Output: "PAHNAPLSIIGYIR"

    Example 2:

        Input: s = "PAYPALISHIRING", numRows = 4
        Output: "PINALSIGYAHRPI"

        Explanation:
        P     I    N
        A   L S  I G
        Y A   H R
        P     I

    Example 3:

        Input: s = "A", numRows = 1
        Output: "A"

    */


    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 6 - Zigzag Conversion *** \n");

        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        int numRows2 = 4;

        String zigzag1 = convert(s1, numRows1);
        String zigzag2 = convert(s1, numRows2);

        print(s1, numRows1, zigzag1);
        print(s1, numRows2, zigzag2);

    }

    public static String convert(String s, int numRows) {

        if(numRows == 1){
            return s;
        }

        StringBuilder stringBuilder = new StringBuilder();

        int length = s.length();

        int cycleLength = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++){

            for(int j = 0; j + i < length; j += cycleLength){

                stringBuilder.append(s.charAt(j + i));

                if(i != 0 && i != numRows - 1 && j + cycleLength - i < length){

                    stringBuilder.append(s.charAt(j + cycleLength -i));

                }

            }

        }

        return stringBuilder.toString();

    }


    public static void print(String s, int n, String z) {
        System.out.println("Original string: " + s +
                " | Number of rows: " + n + "\n" +
                "Output: " + z);
    }

}