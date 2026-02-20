package org.learn.ramu.sort;

public class Main {

    static void printOnce(int n) {
        System.out.println("Hello"); // this will always be 1
    }

    static void printLoop(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Loop " + i); // this will always be n
        }
    }

    static void printNested(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + "," + j); // this will always be n*n
            }
        }
    }

    public static void main(String[] args) {
        int n = 9;

        printOnce(n);
        printLoop(n);
        printNested(n);

        /**
         * for 3: 1,3,9
         * for 6: 1,6,36
         * for 9, 1,9,81
         */
    }
}
