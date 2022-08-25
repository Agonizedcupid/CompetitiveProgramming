package com.aariyan.cp;

public class Main {

    public static void main(String[] args) {
        long[] array = {1,2,3,4,5,6};
        rearrange(array, array.length);
    }

    public static void rearrange(long[] array, int n) {
        for (int i = n - 1, j = 0; i > j - 1; i--) {
            if ( i > j) {
                System.out.print(array[i] + " ");
            }
            System.out.print(array[j] + " ");
            if (j < i) {
                j++;
            }
        }
        System.out.println();

    }

}
