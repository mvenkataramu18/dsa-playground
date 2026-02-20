package org.learn.ramu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashCodingPractice {

    public static void main(String[] args) {
        System.out.println("Contains Duplicate: " + containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println("Contains Duplicate: " + containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println("Is Anagram: " + isAnagram("listen" , "silent"));
        System.out.println("Is Anagram: " + isAnagram("rat" , "car"));
        System.out.println("Is Anagram: " + isAnagram("ab" , "a"));
        System.out.println("Two Sum Indexes In Array is " + Arrays.toString(twoSumIndex(new int[]{2,7,11,15} , 18)));
    }

    public static boolean containsDuplicate(int[] arr) {
        Set<Integer> integerSet = new HashSet<>();

        for (int j : arr) {
            if (integerSet.contains(j)) {
                return true;
            }
            integerSet.add(j);
        }

        return false;
    }

    public static boolean isAnagram(String s1, String s2) {

        if(s1.length() != s2.length()) return false;
        Map<Character,Integer> map = new HashMap<>();
        boolean isAnagram = false;
        for(char c : s1.toCharArray()) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        for(char c : s2.toCharArray()) {
            if(!map.containsKey(c)) return false;

            map.put(c,map.get(c)-1);
            if(map.get(c) == 0) {
                map.remove(c);
            }
        }

        if(map.isEmpty()) isAnagram = true;
        return isAnagram;
    }

    public static int[] twoSumIndex(int[] arr, int sum) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ;  i < arr.length ; i++) {
            int needed = sum - arr[i];

            if(map.containsKey(needed)) {
                return new int[]{map.get(needed) , i};
            }

            map.put(arr[i] , i);
        }
        return new int[]{-1,-1};
    }


}
