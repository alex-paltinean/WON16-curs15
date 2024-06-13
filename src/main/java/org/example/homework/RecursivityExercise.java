package org.example.homework;

/**
 * 3) Palindrome: a word that reads the same backwards as forwards, e.g. madam or ana
 * - in two modes :
 * 3.1) recursive string reverse
 * 3.2) recursive check of first and last letter
 */
public class RecursivityExercise {
    public static void main(String[] args) {
//        System.out.println(isPalindrome("abc"));
//        System.out.println(isPalindrome("ana"));

//        System.out.println(isPalindromeFirstAndLastLetter("abracadabra"));
        System.out.println(isPalindromeFirstAndLastLetter("A man, a plan, a canal – Panama"));
    }

    private static boolean isPalindrome(String text) {
        return text.equals(reverse(text));
    }

    private static String reverse(String text) {
        if (text.length() <= 1) {
            return text;
        }
        // abc ->   r(bc)a ->  r(c)ba -> cba
        // abc -> c r(ab) -> c b r(a) -> cba
//        return reverse(text.substring(1)) + text.charAt(0);
        return text.charAt(text.length() - 1) + reverse(text.substring(0, text.length() - 1));
    }

    private static boolean isPalindromeFirstAndLastLetter(String text){
        String trimmedText = text.toLowerCase().replaceAll("[^a-z]", "");
        return isPalindromeFirstAndLastLetterInternal(trimmedText);
    }

    private static boolean isPalindromeFirstAndLastLetterInternal(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeFirstAndLastLetterInternal(text.substring(1, text.length() - 1));
    }


}
