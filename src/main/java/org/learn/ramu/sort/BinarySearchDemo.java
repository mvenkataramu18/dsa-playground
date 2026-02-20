package org.learn.ramu.sort;

public class BinarySearchDemo {

    static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            System.out.println("low=" + low +
                    ", mid=" + mid +
                    ", high=" + high +
                    ", value=" + arr[mid]);

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17};
        int target = 13;

        int index = binarySearch(arr, target);
        System.out.println("Found at index: " + index);
    }
}

