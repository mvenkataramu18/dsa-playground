package org.learn.ramu.twopointers;

public class MinSubArrayLength {

    public static int minSubArrayLength(int[] numbers, int target) {
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        for(int right = 0 ;  right < numbers.length ; right++) {
            sum = sum + numbers[right];
            while(sum >= target) {
                int windowSize = right - left + 1;
                minLength = Math.min(minLength,windowSize);
                sum = sum - numbers[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        System.out.println("Min Sub Array Length For Target Sum is " + minSubArrayLength(new int[]{1,2,3,4,2,2,2,1},7));
    }

}
