package org.learn.ramu.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 4, 3};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {

        if( left >= right) return;

        // call partition
        int pivot = partition(arr, left, right);
        // call for left of pivot
        sort(arr, left, pivot - 1);
        // call for right of pivot
        sort(arr, pivot + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {

        int leftWall = left - 1;

        int pivotIndex = right;

        for (int i = left; i < right; i++) {
            if (arr[i] < arr[pivotIndex]) {
                leftWall++;
                swap(arr, leftWall, i);
            }
        }

        swap(arr, leftWall + 1, right);
        return leftWall + 1;

    }

    public static void swap(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
