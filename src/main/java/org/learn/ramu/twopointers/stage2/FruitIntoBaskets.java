package org.learn.ramu.twopointers.stage2;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    public static int totalFruit(int[] fruits) {

        int left = 0;
        int maxLength = 0;

        Map<Integer, Integer> count = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {
            count.put(fruits[right] , count.getOrDefault(fruits[right],0) + 1);

            while(count.size() > 2 ) {
                count.put(fruits[left],count.get(fruits[left]) - 1);
                if(count.get(fruits[left]) == 0) {
                    count.remove(fruits[left]);
                }
                left++;
            }

            int windowSize = right - left + 1;
            maxLength = Math.max(windowSize,maxLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        System.out.println(totalFruit(new int[]{1, 2, 1}));
        System.out.println(totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(totalFruit(new int[]{1, 2, 3, 2, 2}));
    }
}

