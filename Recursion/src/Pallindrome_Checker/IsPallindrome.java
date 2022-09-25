package Pallindrome_Checker;

public class IsPallindrome {

    public static void main(String[] args) {
        String input = "ABCDS";
        if (isPalindrome(input, 0, input.length() - 1))
            System.out.println("True");
        else
            System.out.println("False");
    }

    public static boolean isPalindrome(String input, int startPointer, int lastPointer) {
        if (startPointer >= lastPointer) return true; // Means Palindrome
        if (input.charAt(startPointer) != input.charAt(lastPointer))
            return false; // means found at least on non matched character
        return isPalindrome(input, startPointer + 1, lastPointer - 1);
    }
}
