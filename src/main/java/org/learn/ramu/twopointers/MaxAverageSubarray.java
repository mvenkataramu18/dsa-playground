package org.learn.ramu.twopointers;

public class MaxAverageSubarray {

    public static double findMaxAverage(int[] nums, int k) {

        double maxAverage = Double.NEGATIVE_INFINITY;

        int left = 0;
        int right = 0;

        double windowSum = 0.0;

        while (right < nums.length) {

            windowSum = windowSum + nums[right];

            if (right - left + 1 == k) {

                double avarage = windowSum / k;
                maxAverage = Math.max(maxAverage, avarage);

                windowSum = windowSum - nums[left];
                left++;
            }

            right++;
        }

        return maxAverage;
    }


    public static void main(String[] args) {

        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        double result = findMaxAverage(nums, k);

        System.out.println("Max average: " + result);
    }
}
