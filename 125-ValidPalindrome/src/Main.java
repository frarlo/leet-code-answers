public class Main {

    /*
    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
    all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include
    letters and numbers.

    Given a string s, return true if it is a palindrome, or false otherwise.

    Example 1:

        Input: s = "A man, a plan, a canal: Panama"
        Output: true
        Explanation: "amanaplanacanalpanama" is a palindrome.

    Example 2:

        Input: s = "race a car"
        Output: false
        Explanation: "raceacar" is not a palindrome.

    Example 3:

        Input: s = " "
        Output: true
        Explanation: s is an empty string "" after removing non-alphanumeric characters.
        Since an empty string reads the same forward and backward, it is a palindrome.

     */

    public static void main(String[] args) {

        System.out.println("*** Solution for LeetCode problem 125 - Valid Palindrome *** \n");

        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = " ";

        System.out.println(s1 + " | Palindrome? " + isPalindrome(s1));
        System.out.println(s2 + " | Palindrome? " + isPalindrome(s2));
        System.out.println(s3 + " | Palindrome? " + isPalindrome(s3));

    }

    public static boolean isPalindrome(String s){

        s = s.replaceAll("[^a-zA-Z0-9]","").trim().toLowerCase();

        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;

    }


}