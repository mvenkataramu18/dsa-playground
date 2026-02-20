package org.learn.ramu.twopointers.stage2;

public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {

        int left = 0;
        int maxLength = 0;
        int maxFrequency = 0;

        int[] count = new int[26];

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxFrequency = Math.max(maxFrequency, count[s.charAt(right) - 'A']);
            int windowSize = right - left + 1;
            while(windowSize - maxFrequency > k) {
                count[s.charAt(left) - 'A']--;
                left++;
                windowSize = right - left + 1;
            }
            maxLength =  Math.max(windowSize,maxLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));
    }
}

