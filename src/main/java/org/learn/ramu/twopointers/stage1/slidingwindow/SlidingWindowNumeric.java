package org.learn.ramu.twopointers.stage1.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SlidingWindowNumeric {

    public static int maxSumSubArray(int[] arr, int k) throws IllegalAccessException {

        if(k <= 0 || k > arr.length) {
            throw new IllegalAccessException("Invalid K");
        }
        int windowSum = 0;
        int maxSum = 0;
        int left = 0;
        int[] windowBoundaries = new int[2];
        for (int i = 0; i < k; i++) {
            windowSum = windowSum + arr[i];
        }
        maxSum = windowSum;
        windowBoundaries[1] = k - 1;
        for (int right = k; right < arr.length; right++) {
            System.out.print("Left " + left);
            System.out.print(" Right " + right);
            windowSum = windowSum - arr[left] + arr[right];
            System.out.println(" Window Sum: " + windowSum);
            if (windowSum > maxSum) {
                maxSum = windowSum;
                windowBoundaries[0] = left+1;
                windowBoundaries[1] = right;
            }
            left++;
        }
        System.out.println("Window Boundaries For Max Sum Window " + Arrays.toString(windowBoundaries));
        return maxSum;
    }

    public static int minSubArrayLen(int target, int[] arr) {

        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < arr.length; right++) {
            sum = sum + arr[right];
            while (sum >= target) {
                int windowSize = right-left + 1;
                if(windowSize < minLength) {
                    minLength = windowSize;
                }
                sum = sum - arr[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static int subarraySum(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int sum = 0;
        int count = 0;

        for(int n : nums) {

            sum = sum + n;
            int needed = sum - k;
            if(map.containsKey(needed)) {
                count = count + map.get(needed);
            }

            map.put(sum,map.getOrDefault(sum,0) + 1);
        }

        return count;
    }



    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("Max Sum for K window size " + maxSumSubArray(new int[]{2, 1, 5, 1, 3, 2}, 3));
        System.out.println("Smallest SubArray With Sum >= Target " + minSubArrayLen(7,new int[]{2, 1, 5, 2, 3, 2}));
        System.out.println("Prefix Sum " + subarraySum(new int[]{1,2,3},3));
    }
}
