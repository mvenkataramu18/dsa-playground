package org.learn.ramu.sort;

public class RecursionTreeDemo {

    private static int calls = 0;

    public static void dive(int n) {
        calls++;
        System.out.println("Entering n = " + n);

        if (n <= 1) {
            System.out.println("Base case at n = " + n);
            return;
        }

        dive(n / 2);
        dive(n / 2);

        System.out.println("Exiting n = " + n);
    }

    public static void main(String[] args) {
        int n = 8; // try 4, 8, 16
        mergeStyle(8);
        System.out.println();
        mergeStyle(16);
    }

    static void mergeStyle(int n) {
        if (n <= 1) return;

        // Work proportional to n
        for (int i = 0; i < n; i++) {
            System.out.print(".");
        }

        RecursionTreeDemo.mergeStyle(n / 2);
        RecursionTreeDemo.mergeStyle(n / 2);
    }

}

