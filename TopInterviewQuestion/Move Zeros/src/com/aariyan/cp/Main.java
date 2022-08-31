package com.aariyan.cp;

import java.util.Arrays;

public class Main {

    /**
     * Time : O(N)
     * Space : O(1)
     */

    public static void main(String[] args) {
        int[] array = {0};
        moveZeroes(array);
    }

    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
}
