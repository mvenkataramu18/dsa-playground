package org.learn.ramu.sort;

import java.util.Arrays;

public class MinHeap {

    private final int[] heap;
    private int size;

    public MinHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public void insert(int val) {
        heap[size] = val;
        int i = size;

        // bubble up
        // insert the element in the end and compare the value against it's parent and if the value is small then swap and continue this until we reach root
        while(i > 0) {
            int parentIndex = (i -1) / 2;
            if(heap[parentIndex] > heap[i]) {
                swap(parentIndex,i);
            }
            else break;
            i = parentIndex;
        }
        size++;
    }

    public int extractMin() {
        int min = heap[0];
        heap[0] = heap[size - 1];
        heap[size-1] = 0;
        size--;
        heapifyDown(0);
        return min;
    }

    private void heapifyDown(int i) {

        //System.out.println("Before: " + Arrays.toString(heap));
        while (true) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            int smallest = i;

            if(left < size && heap[smallest] > heap[left]) {
                smallest = left;
            }
            if(right < size && heap[smallest] > heap[right]) {
                smallest = right;
            }
            if(smallest == i) break;
            swap(smallest,i);
            i = smallest;
        }
        //System.out.println("After: " + Arrays.toString(heap));
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(5);
        minHeap.insert(10);
        minHeap.insert(4);
        minHeap.insert(15);
        minHeap.insert(2);
        minHeap.insert(8);

        System.out.println(Arrays.toString(minHeap.heap));

        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());

        int[] intArray = new int[]{7, 10, 4, 3, 20, 15};
        System.out.println("1 Largest Element: " + kthLargest(intArray, 1));

        heapSort(intArray);
    }

    public static int kthLargest(int[] arr, int k) {

        MinHeap heap = new MinHeap(k);

        for (int num : arr) {
            if(heap.size() < k) {
                heap.insert(num);
            }
            else if(heap.peek() < num) {
                heap.extractMin();
                heap.insert(num);
            }
        }

        return heap.peek();
    }

    int peek() {
        return heap[0];
    }

    int size() {
        return size;
    }

    public static void heapSort(int[] arr) {
        MinHeap minHeap = new MinHeap(arr.length);

        for(int num : arr) {
            minHeap.insert(num);
        }

        int[] sortedArray = new int[arr.length];
        for(int i = 0 ; i < arr.length ; i++) {
            sortedArray[i] = minHeap.extractMin();
        }

        System.out.println("Sorted Array " + Arrays.toString(sortedArray));
    }

}
