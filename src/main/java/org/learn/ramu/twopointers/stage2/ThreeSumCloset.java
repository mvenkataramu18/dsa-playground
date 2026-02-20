package org.learn.ramu.twopointers.stage2;

import java.util.Arrays;

public class ThreeSumCloset {

    public static int threeSumCloset(int[] nums,int target) {
        Arrays.sort(nums);
        int closestDifference = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length-2 ; i++) {
            int left = i + 1;
            int right = nums.length -1;

            while(left < right) {
                int currentTripletSum = nums[i] + nums[left] + nums[right];
                int currentDifference = Math.abs(currentTripletSum - target);
                if(closestDifference > currentDifference) {
                    closestDifference = currentDifference;
                    sum = currentTripletSum;
                }
                if(currentTripletSum < target) {
                    left++;
                }
                else if(currentTripletSum > target) {
                    right--;
                }
                else {
                    return currentTripletSum;
                }

            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("sum closest to target is " + threeSumCloset(new int[]{-1,2,1,-4},1));
    }
}
