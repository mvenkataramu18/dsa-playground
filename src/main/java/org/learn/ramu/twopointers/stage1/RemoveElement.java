package org.learn.ramu.twopointers.stage1;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {

        int write = 0;

        for (int read = 0; read < nums.length; read++) {
            if (nums[read] != val) {
                nums[write] = nums[read];
                write++;
            }
        }

        return write;
    }

    public static void main(String[] args) {
        System.out.println("Array Length After removing an element is " + removeElement(new int[]{1,2,3,4,5,2,3,5,1},5));
    }
}

