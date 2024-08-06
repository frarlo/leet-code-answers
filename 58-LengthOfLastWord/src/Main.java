public class Main {

    /*

    Given a string s consisting of words and spaces, return the length of the last word in the string.

    A word is a maximal substring consisting of non-space characters only.

    Example 1:

        Input: s = "Hello World"
        Output: 5
        Explanation: The last word is "World" with length 5.

    Example 2:

        Input: s = "   fly me   to   the moon  "
        Output: 4
        Explanation: The last word is "moon" with length 4.

    Example 3:

        Input: s = "luffy is still joyboy"
        Output: 6
        Explanation: The last word is "joyboy" with length 6.

    */


    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 58 - Length of Last Word *** \n");

        String string1 = "Hello World";
        String string2 = "    fly me     to     the     moon   ";
        String string3 = "  short long very short veryverylong";

        int length1 = lengthOfLastWord(string1);
        int length2 = lengthOfLastWord(string2);
        int length3 = lengthOfLastWord(string3);

        print(string1, length1);
        print(string2, length2);
        print(string3, length3);

    }

    public static int lengthOfLastWord(String s){

        s = s.trim();
        String[] stringArray = s.split(" ");

        return stringArray[stringArray.length - 1].length();
    }

    public static void print(String string, int length){
        System.out.println("Last word in '" + string + "' has a length of " + length);
    }

}