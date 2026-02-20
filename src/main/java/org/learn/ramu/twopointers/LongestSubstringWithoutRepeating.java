package org.learn.ramu.twopointers;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {

        int left = 0;
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            if(map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right))+ 1,left);
            }
            map.put(s.charAt(right),right);
            int windowSize = right - left + 1;
            if(windowSize > max) {
                max = windowSize;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println("Longest substring length: " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("Longest substring length: " + lengthOfLongestSubstring("abba"));
    }
}

