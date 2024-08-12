public class Main {

    /*
    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

    A subsequence of a string is a new string that is formed from the original string by deleting some
    (can be none) of the characters without disturbing the relative positions of the remaining characters.
    (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

    Example 1:

        Input: s = "abc", t = "ahbgdc"
        Output: true

    Example 2:

        Input: s = "axc", t = "ahbgdc"
        Output: false

    */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 392 - Is Subsequence *** \n");

        String s1 = "abc", t1 = "ahbgdc";
        String s2 = "axc", t2 = "ahbgdc";

        System.out.println(s1 + " is a subsequence of " + t1 + "? " + isSubsequence(s1,t1));
        System.out.println(s2 + " is a subsequence of " + t2 + "? " + isSubsequence(s2,t2));

    }

    public static boolean isSubsequence(String s, String t) {

        if(s.isEmpty()){
            return true;
        }

        int index = 0;

        for(int i = 0; i < t.length(); i++){

            if(t.charAt(i) == s.charAt(index)){

                index++;

                if(index == s.length()){
                    return true;
                }

            }

        }

        return false;
    }

}