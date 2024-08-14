import java.util.HashMap;
import java.util.Map;

public class Main {

   /*

   Given a string s, find the length of the longest substring without repeating characters.

   Example 1:

       Input: s = "abcabcbb"
       Output: 3

       Explanation: The answer is "abc", with the length of 3.

   Example 2:

        Input: s = "bbbbb"
        Output: 1

        Explanation: The answer is "b", with the length of 1.

   Example 3:

        Input: s = "pwwkew"
        Output: 3

        Explanation: The answer is "wke", with the length of 3.
        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

    */


    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 3 - Longest Substring Without Repeating" +
                " Characters *** \n");

        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        System.out.println("Longest substring for " + s1 + " is " + lengthOfLongestSubstring(s1));
        System.out.println("Longest substring for " + s2 + " is " + lengthOfLongestSubstring(s2));
        System.out.println("Longest substring for " + s3 + " is " + lengthOfLongestSubstring(s3));


    }

    public static int lengthOfLongestSubstring(String s) {

        int length = s.length();

        if(length == 0){
            return 0;
        }

        int maxLength = 0;
        int left = 0;
        int right = 0;

        Map<Character, Integer> hashMap = new HashMap<>();

        while(right < length){

            char ch = s.charAt(right);

            int charCurrentPosition = hashMap.getOrDefault(ch, -1);

            if(charCurrentPosition != -1 && charCurrentPosition >= left){

                maxLength = Math.max(maxLength, right - left);

                left = charCurrentPosition + 1;

            }

            hashMap.put(ch, right);

            right++;
        }

        return Math.max(maxLength, right - left);

    }

}