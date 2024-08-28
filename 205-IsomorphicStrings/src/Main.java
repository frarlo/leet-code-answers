import java.util.HashMap;

public class Main {

    /*

    Given two strings s and t, determine if they are isomorphic.

    Two strings s and t are isomorphic if the characters in s can be replaced to get t.

    All occurrences of a character must be replaced with another character while preserving
    the order of characters. No two characters may map to the same character, but a character may map to itself.

    Example 1:

        Input: s = "egg", t = "add"
        Output: true

    Example 2:

        Input: s = "foo", t = "bar"
        Output: false

    Example 3:

        Input: s = "paper", t = "title"
        Output: true

    */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 205 - Isomorphic Strings *** \n");

        String s1 = "egg";
        String t1 = "add";
        String s2 = "foo";
        String t2 = "bar";
        String s3 = "paper";
        String t3 = "title";

        System.out.println("Are " + s1 + " and " + t1 + " isomorphic? " + isIsomorphic(s1, t1));
        System.out.println("Are " + s2 + " and " + t2 + " isomorphic? " + isIsomorphic(s2, t2));
        System.out.println("Are " + s3 + " and " + t3 + " isomorphic? " + isIsomorphic(s3, t3));

    }

    public static boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> hashMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){

            if(hashMap.containsKey(s.charAt(i))){

                if(!hashMap.get(s.charAt(i)).equals(t.charAt(i))){
                    return false;
                }

            }else{

                if(hashMap.containsValue(t.charAt(i))){
                    return false;
                }

                hashMap.put(s.charAt(i), t.charAt(i));
            }
        }

        return true;
    }

}