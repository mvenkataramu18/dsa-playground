package org.learn.ramu.sort;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] arr) {
        sort(arr,0,arr.length-1);
    }

    public static void sort(int[] arr, int left, int right) {
        System.out.println("sort(" + left + ", " + right + ")");


        if(left >= right ) return;

        int mid =  left + (right-left) /2;
        sort(arr,left,mid);
        sort(arr,mid + 1,right);

        merge(arr,left,mid,right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        System.out.println("merge(" + left + ", " + mid + ", " + right + ")");
        // size of left array
        int n1 = mid - left + 1;

        //size of right array
        int n2 = right - mid;

        //left array
        int[] leftArray = new int[n1];
        for(int i = 0 ; i < n1 ; i ++) {
            leftArray[i] = arr[left + i];
        }

        int[] rightArray = new int[n2];
        for(int j = 0 ; j < n2 ; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;
        while( i < n1 && j < n2) {
            if(leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            }
            else {
                arr[k++] = rightArray[j++];
            }
        }

        // copying over left items
        while( i < n1) {
            arr[k++] = leftArray[i++];
        }
        while (j < n2) {
            arr[k++] = rightArray[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3 ,4 , 2 , 5 , 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
