import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    /*

    Given an array of strings strs, group the anagrams together. You can return the answer in any order.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    typically using all the original letters exactly once.

    Example 1:

        Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    Example 2:

        Input: strs = [""]
        Output: [[""]]

    Example 3:

        Input: strs = ["a"]
        Output: [["a"]]

    */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 49 - Group Anagrams *** \n");

        String[] strs1 = {"eat","tea","tan","ate","nat","bat"};
        String[] strs2 = {""};
        String[] strs3 = {"a"};

        System.out.println("Anagram Grouping for '" + Arrays.toString(strs1) +"' is: '" + groupAnagrams(strs1)+"'.");
        System.out.println("Anagram Grouping for '" + Arrays.toString(strs2) +"' is: '" + groupAnagrams(strs2)+"'.");
        System.out.println("Anagram Grouping for '" + Arrays.toString(strs3) +"' is: '" + groupAnagrams(strs3)+"'.");

    }

    public static List<List<String>> groupAnagrams(String[] strs){

        if(strs.length == 0){
            return new ArrayList<>();
        }

        HashMap<String, List<String>> hashMap = new HashMap<>();

        for(String st : strs){

            char[] ca = st.toCharArray();
            Arrays.sort(ca);
            String keyString = String.valueOf(ca);

            if(!hashMap.containsKey(keyString)){
                hashMap.put(keyString, new ArrayList<>());
            }

            hashMap.get(keyString).add(st);
        }

        return new ArrayList<>(hashMap.values());
    }

}