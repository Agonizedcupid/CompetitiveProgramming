package com.aariyan.cp;

import java.util.Arrays;

public class Main {

    /**
     * Time: O(N)<br/>
     * Space: O(1) <br/>
     */

    public static void main(String[] args) {
        int[] array = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}; //Result: [0, 1, 2, 3, 4, 2, 2, 3, 3, 4]
        System.out.println(removeDuplicates(array));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                count++;
                nums[count] = nums[i];
            }
        }

        System.out.println(Arrays.toString(nums));
        return count + 1;
    }
}
