package org.learn.ramu.twopointers;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {

            int area = (right - left) * Math.min(height[left],height[right]);
            if(max < area) {
                max = area;
            }

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("Container With Most Water " + maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
