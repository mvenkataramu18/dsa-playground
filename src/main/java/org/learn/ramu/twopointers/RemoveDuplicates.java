package org.learn.ramu.twopointers;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {

        int write = 0;
        int read = 0;

        while (read < nums.length) {
            if(read == 0 || nums[write] != nums[read]) {
                nums[write] = nums[read];
                write++;
            }
            read++;
        }
        return write;
    }

    public static void main(String[] args) {
        System.out.println("Array size after removing duplicates is " + removeDuplicates(new int[]{10,20,10,4,5}));
    }
}

