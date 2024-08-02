public class Main {

    /*

    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII,
    which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right. However,
    the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before
    the five we subtract it making four. The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
    Given a roman numeral, convert it to an integer.

    */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 13 - Roman to Integer *** \n");

        String roman1 = "XVIII";
        String roman2 = "MMCLXV";
        String roman3 = "CM";

        int integer1 = romanToInt(roman1);
        int integer2 = romanToInt(roman2);
        int integer3 = romanToInt(roman3);

        System.out.println("Roman numeral: " + roman1 + " equals to " + integer1);
        System.out.println("Roman numeral: " + roman2 + " equals to " + integer2);
        System.out.println("Roman numeral: " + roman3 + " equals to " + integer3);

    }

    public static int romanToInt(String string) {

        int result = 0;

        for(int i = 0; i < string.length(); i++){

            char ch = string.charAt(i);

            switch(ch){

                case 'I':
                    result++;
                    break;

                case 'V':
                    result += 5;
                    if(i > 0 && string.charAt(i - 1) == 'I'){
                        result -= 2;
                    }
                    break;

                case 'X':
                    result += 10;
                    if(i > 0 && string.charAt(i - 1) == 'I'){
                        result -= 2;
                    }
                    break;

                case 'L':
                    result += 50;
                    if(i > 0 && string.charAt(i - 1) == 'X'){
                        result -= 20;
                    }
                    break;

                case 'C':
                    result += 100;
                    if(i > 0 && string.charAt(i - 1) == 'X'){
                        result -= 20;
                    }
                    break;

                case 'D':
                    result +=500;
                    if(i > 0 && string.charAt(i - 1) == 'C'){
                        result -= 200;
                    }
                    break;

                case 'M':
                    result += 1000;
                    if(i > 0 && string.charAt(i - 1) == 'C'){
                        result -= 200;
                    }
                    break;
            }
        }

        return result;

    }

}