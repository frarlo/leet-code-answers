import java.util.Arrays;

public class Main {

    /*

    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".

    Example 1:

        Input: strs = ["flower","flow","flight"]
        Output: "fl"

    Example 2:

        Input: strs = ["dog","racecar","car"]
        Output: ""
        Explanation: There is no common prefix among the input strings.

    */


    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 14 - Longest Common Prefix *** \n");

        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"dogmeat", "racecar", "carbuble"};

        String prefix1 = longestCommonPrefix(strs1);
        String prefix2 = longestCommonPrefix(strs2);


        print(strs1, prefix1);
        print(strs2, prefix2);

    }

    public static String longestCommonPrefix(String[] strs){

        String prefix = strs[0];

        for(int i = 1; i < strs.length; i++){

            while(strs[i].indexOf(prefix) != 0){

                prefix = prefix.substring(0, prefix.length() - 1);

                if(prefix.isEmpty()){
                    return "";
                }

            }

        }

        return prefix;
    }

    public static void print(String[] strs, String prefix){
        System.out.println("Strings: " + Arrays.toString(strs) + "' has a common prefix: " + prefix);
    }

}