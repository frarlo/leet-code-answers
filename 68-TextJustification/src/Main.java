import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    /*

    Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth
    characters and is fully (left and right) justified.

    You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra
    spaces ' ' when necessary so that each line has exactly maxWidth characters.

    Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does
    not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the
    right.

    For the last line of text, it should be left-justified, and no extra space is inserted between words.

    Note:

        A word is defined as a character sequence consisting of non-space characters only.
        Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
        The input array words contains at least one word.


    Example 1:

        Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
        Output:
        [
           "This    is    an",
           "example  of text",
           "justification.  "
        ]

    Example 2:

        Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
        Output:
        [
          "What   must   be",
          "acknowledgment  ",
          "shall be        "
        ]

        Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be
        left-justified instead of fully-justified.

        Note that the second line is also left-justified because it contains only one word.

    Example 3:

        Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.",
        "Art","is","everything","else","we","do"], maxWidth = 20

        Output:
        [
          "Science  is  what we",
          "understand      well",
          "enough to explain to",
          "a  computer.  Art is",
          "everything  else  we",
          "do                  "
        ]

     */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 68 - Text Justification *** \n");

        String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth1 = 16;

        System.out.println(fullJustify(words1, maxWidth1));

    }

    public static List<String> fullJustify(String[] words, int maxWidth) {

        List<String> outputText = new ArrayList<>();
        List<StringBuilder> row = new ArrayList<>();

        int rowLetters = 0;

        for (final String word : words) {

            if (rowLetters + row.size() + word.length() > maxWidth) {
                int spaces = maxWidth - rowLetters;

                if (row.size() == 1) {
                    for (int i = 0; i < spaces; ++i){
                        row.get(0).append(" ");
                    }
                } else {
                    for (int i = 0; i < spaces; ++i){
                        row.get(i % (row.size() - 1)).append(" ");
                    }
                }

                String joinedRow = row.stream().map(StringBuilder::toString).collect(Collectors.joining(""));
                outputText.add(joinedRow);

                row.clear();
                rowLetters = 0;
            }

            row.add(new StringBuilder(word));
            rowLetters += word.length();

        }

        String lastRow = row.stream().map(StringBuilder::toString).collect(Collectors.joining(" "));
        StringBuilder stringBuilder = new StringBuilder(lastRow);

        int spacesToBeAdded = maxWidth - stringBuilder.length();

        for (int i = 0; i < spacesToBeAdded; ++i){
            stringBuilder.append(" ");
        }

        outputText.add(stringBuilder.toString());

        return outputText;
    }

}