
public class Main {

    /*
    Seven different symbols represent Roman numerals with the following values:

    Symbol	Value
        I	1
        V	5
        X	10
        L	50
        C	100
        D	500
        M	1000

    Roman numerals are formed by appending the conversions of decimal place values from highest to lowest.
     Converting a decimal place value into a Roman numeral has the following rules:

    If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted
    from the input, append that symbol to the result, subtract its value, and convert the remainder to a
    Roman numeral. If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted
    from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX.
    Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
    Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10.
    You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the
    subtractive form.

    Given an integer, convert it to a Roman numeral.

    Example 1:

        Input: num = 3749

        Output: "MMMDCCXLIX"

        Explanation:

        3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
         700 = DCC as 500 (D) + 100 (C) + 100 (C)
          40 = XL as 10 (X) less of 50 (L)
           9 = IX as 1 (I) less of 10 (X)

        Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places

    Example 2:

        Input: num = 58

        Output: "LVIII"

        Explanation:

        50 = L
         8 = VIII

    Example 3:

        Input: num = 1994

        Output: "MCMXCIV"

        Explanation:

        1000 = M
         900 = CM
          90 = XC
           4 = IV

     */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 12 - Integer to Roman *** \n");

        int integer1 = 3749;
        int integer2 = 58;
        int integer3 = 1994;

        String roman1 = intToRoman(integer1);
        String roman2 = intToRoman(integer2);
        String roman3 = intToRoman(integer3);

        print(integer1, roman1);
        print(integer2, roman2);
        print(integer3, roman3);

    }


    public static String intToRoman(int num) {

        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder romanNumeral = new StringBuilder();

        for (int i = 0 ; i < romans.length; i++){

            while (num >= numbers[i]){

                num -= numbers[i];

                romanNumeral.append(romans[i]);
            }

        }

        return romanNumeral.toString();
    }

    public static void print(int number, String roman){
        System.out.println("The number " + number + " has the roman numeral: " + roman);
    }

}