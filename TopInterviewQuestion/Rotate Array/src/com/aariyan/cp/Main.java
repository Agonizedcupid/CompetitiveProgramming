package com.aariyan.cp;

import java.util.Arrays;

public class Main {
    /**
     * [5, 2, 3, 4, 1, 6, 7]
     * [5, 6, 3, 4, 1, 2, 7]
     * [5, 6, 7, 4, 1, 2, 3]
     * [5, 6, 7, 1, 4, 2, 3]
     * [5, 6, 7, 1, 2, 4, 3]
     * [5, 6, 7, 1, 2, 3, 4]
     * [5, 6, 7, 1, 2, 3, 4]
     * <p>
     * [4, 2, 3, 1, 5, 6, 7]
     * [4, 5, 3, 1, 2, 6, 7]
     * [4, 5, 6, 1, 2, 3, 7]
     * [4, 5, 6, 7, 2, 3, 1]
     * [4, 5, 6, 2, 7, 3, 1]
     * [4, 5, 6, 2, 3, 7, 1]
     * [4, 5, 6, 2, 3, 7, 1]
     */

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        //int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 0;

//        int[] array = {-1, -100, 3, 99};
//        int k = 2;

//        int[] array = {1, 2};
//        int k = 3;

//        int[] array = {1, 2, 3};
//        int k = 3;

        //rotate(array, k);
        //rotateInN(array, k);
        rotation(array, k);
        //r(array, k);
    }

    public static void rotation(int[] array, int k) {
        int finalK = k % array.length;
        // Last N-K element:
        swapArray(array, array.length - finalK, array.length - 1);
        // Rest of the element from start to K
        swapArray(array, 0, array.length - 1 - finalK);

        //Now reverse the whole element:
        swapArray(array, 0, array.length - 1);


        //Finally print the output:
        //System.out.println(Arrays.toString(array));
    }

    public static void swapArray(int[] array, int startIndex, int lastIndex) {
        while (lastIndex >= startIndex) {
            int temp = array[startIndex];
            array[startIndex] = array[lastIndex];
            array[lastIndex] = temp;
            startIndex++;
            lastIndex--;
        }
    }

    public static void rotateInN(int[] array, int k) {
        if (k > array.length) {
            k = k - array.length;
        }
        int carry = k;
        for (int i = 0; i < array.length - 1; i++) {
            int temp = array[i];
            if (k < 1) {
                if (array.length % 2 != 0 & carry % 2 == 0) {
                    k++;
                } else {
                    k = carry;
                }

            }
            if (k >= 1) {
                array[i] = array[array.length - k];
                array[array.length - k] = temp;
                k--;
            }
            System.out.println(Arrays.toString(array));
//            else if ((array.length - (carry * 2)) != 0) {
//                array[i] = array[i + 1];
//                array[i + 1] = temp;
//            }

        }
        System.out.println(Arrays.toString(array));
    }

    public static void r(int[] nums, int k) {
        // length of array
        int len = nums.length;
        // rotated array
        int[] rotate = new int[len];
        for (int i = 0; i < len; i++)
            rotate[i] = nums[i];
        // for each item
        for (int i = 0; i < nums.length; i++)
            nums[(i + k) % len] = rotate[i];


        System.out.println(Arrays.toString(nums));
    }

    //Time O(N^N)
    public static void rotate(int[] nums, int k) {
        if (nums.length <= 1) {
            System.out.println(Arrays.toString(nums));
        } else { // if the length is bigger than 1:
            for (int i = 0, j = nums.length - k; i <= nums.length - k; i++) {
                while (j != nums.length) {
                    System.out.print(nums[j] + " ");
                    j++;
                }
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        }
    }
}
