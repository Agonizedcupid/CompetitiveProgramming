package com.aariyan.cp;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(countTriplets(new int[]{1, 5, 3, 2}));
    }

    public static int countTriplets(int[] array) {
        Arrays.sort(array);
        int found = 0;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                sum = array[i] + array[j];
                found = Arrays.binarySearch(array, sum);
                if (found > 0) {
                    count++;
                }
            }
        }
        return count;
    }

}
