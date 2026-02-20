package org.learn.ramu.twopointers;

public class Palindrome {

    public static void main(String[] args) {
        String s = "racecar";
        System.out.println(s + "is palindrome: " + isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
