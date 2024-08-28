import java.util.Arrays;

public class Main {

    /*

    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    typically using all the original letters exactly once.

    Example 1:

        Input: s = "anagram", t = "nagaram"
        Output: true

    Example 2:

        Input: s = "rat", t = "car"
        Output: false

    */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 242 - Valid Anagram *** \n");

        String s1 = "anagram";
        String t1 = "nagaram";
        String s2 = "rat";
        String t2 = "car";
        String s3 = "jamon";
        String t3 = "monja";

        System.out.println("Is '" + t1 + "' an anagram of '" + s1 + "'? " + isAnagram(s1, t1));
        System.out.println("Is '" + t2 + "' an anagram of '" + s2 + "'? " + isAnagram(s2, t2));
        System.out.println("Is '" + t3 + "' an anagram of '" + s3 + "'? " + isAnagram(s3, t3));


    }

    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        for (int i = 0; i < sArray.length; i++) {
            if(sArray[i] != tArray[i]){
                return false;
            }
        }

        return true;
    }

}