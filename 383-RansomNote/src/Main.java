
public class Main {

    /*

    Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using
    the letters from magazine and false otherwise.

    Each letter in magazine can only be used once in ransomNote.

    Example 1:

        Input: ransomNote = "a", magazine = "b"
        Output: false

    Example 2:

        Input: ransomNote = "aa", magazine = "ab"
        Output: false

    Example 3:

        Input: ransomNote = "aa", magazine = "aab"
        Output: true

    */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 383 - Ransom Note *** \n");

        String ransomNote1 = "aab";
        String magazine1 = "baa";
        String ransomNote2 = "aa";
        String magazine2 = "ab";
        String ransomNote3 = "aa";
        String magazine3 = "aab";

        System.out.println("Ransom 1 Note output: " + canConstruct(ransomNote1, magazine1));
        System.out.println("Ransom 2 Note output: " + canConstruct(ransomNote2, magazine2));
        System.out.println("Ransom 3 Note output: " + canConstruct(ransomNote3, magazine3));

    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        int ransomNoteLength = ransomNote.length();
        int magazineLength = magazine.length();

        if(ransomNoteLength > magazineLength) {
            return false;
        }

        int[] frequency = new int[26];

        for(int i = 0; i < magazineLength; i++){

            frequency[magazine.charAt(i) - 'a']++;

        }

        for(int j = 0; j < ransomNoteLength; j++){

            if(frequency[ransomNote.charAt(j) - 'a'] == 0){
                return false;
            }

            frequency[ransomNote.charAt(j) - 'a']--;
        }

        return true;
    }
}