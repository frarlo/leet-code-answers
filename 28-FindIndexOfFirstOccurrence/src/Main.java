public class Main {

    /*
    Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    Example 1:

        Input: haystack = "sadbutsad", needle = "sad"
        Output: 0
        Explanation: "sad" occurs at index 0 and 6.
        The first occurrence is at index 0, so we return 0.

    Example 2:

        Input: haystack = "leetcode", needle = "leeto"
        Output: -1
        Explanation: "leeto" did not occur in "leetcode", so we return -1.
     */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 28 - Find the Index of the First Occurrence in a String *** \n");

        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        String haystack2 = "leetcode";
        String needle2 = "leeto";
        String haystack3 = "hello";
        String needle3 = "ll";

        System.out.println("Output 1: " + strStr(haystack1,needle1));
        System.out.println("Output 2: " + strStr(haystack2,needle2));
        System.out.println("Output 3: " + strStr(haystack3,needle3));

    }

    public static int strStr(String haystack, String needle){

        int haystackLength = haystack.length();
        int needleLength = needle.length();

        for(int i = 0; i <= haystackLength - needleLength; i++){

            if(haystack.substring(i, i + needleLength).equals(needle)){
                return i;
            }

        }

        return -1;

    }


    /* The laziest solution...:
    public static int strStr(String haystack, String needle){

        return haystack.indexOf(needle);

    }*/

}