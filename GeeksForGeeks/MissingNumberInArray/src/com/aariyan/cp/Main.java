package com.aariyan.cp;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {6, 1, 2, 8, 3, 4, 7, 10, 5};
        //System.out.println(MissingNumber(array, array.length));
        //second approach:
        int result = secondApproach(array, array.length);
        System.out.println(result);
    }

    private static int secondApproach(int[] array, int n) {

        int sum = ((n + 1) * (n + 2)) / 2;
        System.out.println(sum);
        for (int i = 0; i < n; i++)
            sum -= array[i];
        return sum;

    }

    public static int MissingNumber(int[] array, int n) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        for (int i = 1; i <= n; i++) {
            boolean checkFound = performBinarySearch(array, 0, array.length, i);
            if (!checkFound) {
                return i;
            }
        }
        return -1;
    }

    public static boolean performBinarySearch(int[] array, int startIndex, int lastIndex, int toFound) {
        int mid = startIndex + (lastIndex - startIndex) / 2;
        if (toFound == array[mid]) {
            return true;
        }
        if (lastIndex >= startIndex) {
            if (toFound < array[mid]) {
                return performBinarySearch(array, startIndex, mid - 1, toFound);
            } else {
                return performBinarySearch(array, mid + 1, lastIndex, toFound);
            }
        }
        return false;
    }
}
