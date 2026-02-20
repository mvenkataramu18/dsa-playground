package org.learn.ramu.twopointers.stage1;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {

    public static String minimumWindowSubstring(String main, String target) {

        int minWindowLength = Integer.MAX_VALUE;
        String shortestSubString = "";
        Map<Character, Integer> needMap = new HashMap<>();
        for (char c : target.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }
        int need = needMap.size();
        Map<Character, Integer> haveMap = new HashMap<>();
        int left = 0;
        int have = 0;
        for (int right = 0; right < main.length(); right++) {
            char rightCharacter = main.charAt(right);
            haveMap.put(rightCharacter, haveMap.getOrDefault(rightCharacter, 0) + 1);
            if (needMap.containsKey(rightCharacter) && haveMap.get(rightCharacter) == needMap.get(rightCharacter)) {
                have++;
            }
            while (need == have) {
                int windowSize = right - left + 1;
                if (windowSize < minWindowLength) {
                    minWindowLength = windowSize;
                    shortestSubString = main.substring(left, right + 1);
                }
                char leftCharacter = main.charAt(left);
                haveMap.put(leftCharacter, haveMap.get(leftCharacter) - 1);
                if (needMap.containsKey(leftCharacter) && haveMap.get(leftCharacter) < needMap.get(leftCharacter)) {
                    have--;
                }
                if (haveMap.get(leftCharacter) == 0) {
                    haveMap.remove(leftCharacter);
                }
                left++;
            }
        }

        return shortestSubString;
    }

    public static void main(String[] args) {
        System.out.println(
                "Shortest Substring that contains all of target string is " + minimumWindowSubstring("ADOBECODEBANC",
                        "ABC"));
    }

}
