package org.learn.ramu.twopointers.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowString {

    public static int longest(String s) {

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int max = 0;
        String maxWindow = null;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            if (map.get(c) != null) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            int windowSize = right - left + 1;
            if (windowSize > max) {
                max = windowSize;
                maxWindow = s.substring(left, right + 1);
            }
        }
        System.out.print("Max window without duplicates is '" + maxWindow);
        return max;
    }

    public static int longestKDistinct(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int max = 0;
        String windowSubString = "";
        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > k) {
                char characterAtLeftString = s.charAt(left);
                int frequencyOfLeftCharacter = map.get(characterAtLeftString);
                if (frequencyOfLeftCharacter == 1) {
                    map.remove(characterAtLeftString);
                } else {
                    map.put(characterAtLeftString, frequencyOfLeftCharacter - 1);
                }
                left++;
            }

            int windowSize = right - left + 1;
            if (windowSize > max) {
                max = windowSize;
                windowSubString = s.substring(left, right + 1);
            }
        }
        System.out.print("Longest substring with k distinct characters is '" + windowSubString);
        return max;
    }

    public static int longestReplacement(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;
        String windowSubstring = "";
        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > maxFreq) {
                maxFreq = map.get(c);
            }

            while ((right - left + 1) - maxFreq > k) {
                char characterAtLeftIndex = s.charAt(left);
                int frequencyOfLeftCharacter = map.get(characterAtLeftIndex);
                map.put(characterAtLeftIndex, frequencyOfLeftCharacter - 1);
                left++;
            }
            int windowSize = right - left + 1;
            if (windowSize > maxLen) {
                windowSubstring = s.substring(left,right + 1);
                maxLen = windowSize;
            }
        }
        System.out.print("Longest Substring with only K replacements is '" + windowSubstring);
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("' and window length is " + longest("tmmzuxt"));
        System.out.println("' and window length is " + longestKDistinct("eceba", 2));
        System.out.println("' and window length is " + longestReplacement("AABABBA", 1));
        System.out.println("' and window length is " + longestReplacement("ABAB", 2));
        System.out.println("' and window length is " + longestReplacement("AAAA", 2));



    }

}



