import java.util.HashMap;

public class Main {

    /*

    Given a pattern and a string s, find if s follows the same pattern.

    Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

    Example 1:

        Input: pattern = "abba", s = "dog cat cat dog"
        Output: true

    Example 2:

        Input: pattern = "abba", s = "dog cat cat fish"
        Output: false

    Example 3:

        Input: pattern = "aaaa", s = "dog cat cat dog"
        Output: false

    */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 290 - Word Pattern *** \n");

        String pattern1 = "abba";
        String s1 = "dog cat cat dog";
        String pattern2 = "abba";
        String s2 = "dog cat cat fish";
        String pattern3 = "abdc";
        String s3 = "dog cat fish cow";

        System.out.println("Is '" + pattern1 + "' a pattern of '" + s1 + "'? " + wordPattern(pattern1, s1));
        System.out.println("Is '" + pattern2 + "' a pattern of '" + s2 + "'? " + wordPattern(pattern2, s2));
        System.out.println("Is '" + pattern3 + "' a pattern of '" + s3 + "'? " + wordPattern(pattern3, s3));


    }

    public static boolean wordPattern(String pattern, String s) {

        HashMap<Character, String> hashMap = new HashMap<>();
        String[] words = s.split(" ");

        if(pattern.length() != words.length){
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {

            if(hashMap.containsKey(pattern.charAt(i))) {

                if(!hashMap.get(pattern.charAt(i)).equals(words[i])){
                    return false;
                }

            }else{
                if(hashMap.containsValue(words[i])){
                    return false;
                }

                hashMap.put(pattern.charAt(i), words[i]);
            }
        }

        return true;
    }

}