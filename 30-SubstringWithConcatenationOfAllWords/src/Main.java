import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

   /*

    You are given a string s and an array of strings words. All the strings of words are of the same length.

    A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

    For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are
    all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any
    permutation of words.

    Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any
    order.

    Example 1:

        Input: s = "barfoothefoobarman", words = ["foo","bar"]

        Output: [0,9]

        Explanation:

        The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
        The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

    Example 2:

        Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]

        Output: []

        Explanation:

        There is no concatenated substring.

    Example 3:

        Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]

        Output: [6,9,12]

        Explanation:

        The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
        The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
        The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].

    */


    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 30 - Substring With Concatenation of All Words*** \n");

        String s1 = "barfoothefoobarman";
        String[] words1 = {"foo", "bar"};
        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = {"word", "good", "best", "word"};
        String s3 = "barfoofoobarthefoobarman";
        String[] words3 = {"bar", "foo", "the"};

        System.out.println("Starting indexes of the substrings located in " + s1 + " are " + findSubstring(s1, words1));
        System.out.println("Starting indexes of the substrings located in " + s2 + " are " + findSubstring(s2, words2));
        System.out.println("Starting indexes of the substrings located in " + s3 + " are " + findSubstring(s3, words3));

    }

    public static List<Integer> findSubstring(String s, String[] words) {

        if(s.isEmpty() || words.length == 0){
            return new ArrayList<>();
        }

        // Declaring the HashMap and then populate it with the count of each word:
        Map<String, Integer> wordCount = new HashMap<>();

        for(String word : words){
            wordCount.merge(word, 1, Integer::sum);
        }

        int stringLength = s.length();
        int numberOfWords = words.length;
        // The word length is declared assuming that all words are the same length (as stated in the problem):
        int wordLength = words[0].length();

        List<Integer> indexesList = new ArrayList<>();

        // Now we iterate over all the possible word start indexes and check for valid substrings:
        for(int i = 0; i < wordLength; i++){

            Map<String, Integer> currentCount = new HashMap<>();
            int left = i;
            int right = i;
            int totalWords = 0;

            // Expanding the window to the right, adding words to the current window count:
            while(right + wordLength <= stringLength){

                String substring = s.substring(right, right + wordLength);
                right += wordLength;

                // If the word is not in the original word list we will reset the window:
                if(!wordCount.containsKey(substring)){
                    currentCount.clear();
                    left = right;
                    totalWords = 0;
                    continue;
                }

                // Increasing the count for the current word in the window:
                currentCount.merge(substring, 1, Integer::sum);
                totalWords++;

                // If a word count exceeds its count in wordCount we will reduce FROM the left side:
                while(currentCount.get(substring) > wordCount.get(substring)){

                    String removed = s.substring(left, left + wordLength);
                    left += wordLength;
                    currentCount.merge(removed, -1, Integer::sum);
                    totalWords--;
                }

                if(totalWords == numberOfWords){
                    indexesList.add(left);
                }
            }
        }

        return indexesList;
    }

}