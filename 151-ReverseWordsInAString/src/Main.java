public class Main {

    /*

    Given an input string s, reverse the order of the words.
    A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
    Return a string of the words in reverse order concatenated by a single space.

    Note that s may contain leading or trailing spaces or multiple spaces between two words.
    The returned string should only have a single space separating the words. Do not include any extra spaces.

    Example 1:

        Input: s = "the sky is blue"
        Output: "blue is sky the"

    Example 2:

        Input: s = "  hello world  "
        Output: "world hello"

        Explanation: Your reversed string should not contain leading or trailing spaces.

    Example 3:

        Input: s = "a good   example"
        Output: "example good a"

        Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

    */


    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 14 - Longest Common Prefix *** \n");

        String s1 = "the sky is blue";
        String s2 = "    hello world  ";
        String s3 = "a good     example";

        String s1reversed = reverseWords(s1);
        String s2reversed = reverseWords(s2);
        String s3reversed = reverseWords(s3);

        print(s1, s1reversed);
        print(s2, s2reversed);
        print(s3, s3reversed);

    }

    // 5ms Solution (Former was 9ms) But it can be greatly improved.
    public static String reverseWords(String s){

        s = s.trim();
        s = s.replaceAll("\\s+", " ");

        String[] stringArray = s.split(" ");
        int length = stringArray.length;
        String[] reversedArray = new String[length];

        int index = 0;

        for(int i = length - 1; i >= 0; i--){
            reversedArray[i] = stringArray[index];
            index++;
        }

        StringBuilder reversedString = new StringBuilder();

        for(String st : reversedArray){
            reversedString.append(st).append(" ");
        }

        return reversedString.toString().trim();

    }

    public static void print(String s1, String s2){
        System.out.println("Original string: " + s1 + "\nReversed string: " + s2 +"\n");
    }

}