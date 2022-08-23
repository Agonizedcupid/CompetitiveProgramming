package com.aariyan.cp;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] array = {5, 15, 10, 300};
        int k = 12;
        System.out.println(maxSumPairWithDifferenceLessThanK(array, array.length, k));

    }

    public static int maxSumPairWithDifferenceLessThanK(int[] arr, int N, int K) {
        Arrays.sort(arr);
        int sum = 0;
        for (int i = N - 1; i > 0; i--) {
            if (Math.abs(arr[i] - arr[i - 1]) < K) {
                sum += (arr[i] + arr[i - 1]);
                --i;
            }
        }
        return sum;
    }

}
