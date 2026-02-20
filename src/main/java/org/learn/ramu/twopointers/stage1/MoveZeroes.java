package org.learn.ramu.twopointers.stage1;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {

        int write = 0;

        for (int read = 0; read < nums.length; read++) {

            if(nums[read] != 0) {
                nums[write] = nums[read];
                write++;
            }

        }

        while(write < nums.length) {
            nums[write] = 0;
            write++;
        }
    }


    public static void main(String[] args) {

        int[] nums = {0,1,0,3,12};

        moveZeroes(nums);

        for (int n : nums)
            System.out.print(n + " ");
    }
}
