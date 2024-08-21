import java.util.HashMap;
import java.util.Map;

public class Main {

    /*
    Given two strings s and t of lengths m and n respectively, return the minimum window substring
    of s such that every character in t (including duplicates) is included in the window. If there
    is no such substring, return the empty string "".

    The testcases will be generated such that the answer is unique.

    Example 1:

        Input: s = "ADOBECODEBANC", t = "ABC"
        Output: "BANC"

        Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

    Example 2:

        Input: s = "a", t = "a"
        Output: "a"

        Explanation: The entire string s is the minimum window.

    Example 3:

        Input: s = "a", t = "aa"
        Output: ""

        Explanation: Both 'a's from t must be included in the window.
        Since the largest window of s only has one 'a', return empty string.

     */


    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 76 - Minimum Window Substring *** \n");

        String s1 = "ADOBECODEBANC", t1 = "ABC";
        String s2 = "a", t2 = "a";
        String s3 = "a", t3 = "aa";

        System.out.println("The minimum window substring for " + s1 + " is " + minWindow(s1, t1));
        System.out.println("The minimum window substring for " + s2 + " is " + minWindow(s2, t2));
        System.out.println("The minimum window substring for " + s3 + " is " + minWindow(s3, t3));


    }

    public static String minWindow(String s, String t) {

        int unitLength = t.length();
        int stringLength = s.length();

        Map<Character, Integer> characterMap = new HashMap<>();

        // In this loop we save in out map the amount of times a character repeats in "t":
        for(int i = 0; i < unitLength; i++){
            char ch = t.charAt(i);
            if (characterMap.containsKey(ch)){
                characterMap.put(ch, characterMap.get(ch) + 1);
            }else{
                characterMap.put(ch, 1);
            }
        }

        // This variable will store the "t" characters that have been found:
        int count = 0;
        // Two pointers (start and end) of our window:
        int start = 0, end = 0;
        // Stores the minimum length between the start and the end:
        int min = Integer.MAX_VALUE;
        // Stores the initial position of each minimum substring:
        int head = 0;

        // While the end is lower than the string length...
        while(end < stringLength){

            // We will obtain the char at the end position of our window
            char ch = s.charAt(end);

            // If the character is contained in our map is a "t" character:
            if(characterMap.containsKey(ch)){

                // We reduce the count of that character in our map:
                characterMap.put(ch, characterMap.get(ch) - 1);

                // If the value of the character is not negative we update our count variable.
                if(characterMap.get(ch) >= 0){
                    count++;
                }
            }

            // Expanding our window in its end (right).
            end++;

            // While the count is equal to the length of the "t" string the loop will execute:
            while(count == unitLength){

                // If the length of the window (end-start) is lesser than minimum length...
                if(end - start < min){
                    // We update the minimum length and the head:
                    min = end - (head = start);
                }

                // Obtaining the char in the position at start of the "s" string:
                char cha = s.charAt(start);

                // If the character is in our map...
                if(characterMap.containsKey(cha)){

                    // We increment its count in our map since we are stretching our window:
                    characterMap.put(cha, characterMap.get(cha) + 1);

                    // If the count of that value in our map is greater than zero:
                    if(characterMap.get(cha) > 0){
                        // We substract one from the overall count:
                        count--;
                    }
                }

                // We update the start of our window (stretching it):
                start++;
            }

        }

        // If the min variable has remained unchanged we return an empty string:
        if(min == Integer.MAX_VALUE){
            return "";
        }

        // Finally we return a substring of the "s" string, starting in head, and with a length from head to min:
        return s.substring(head, head + min);
    }

}