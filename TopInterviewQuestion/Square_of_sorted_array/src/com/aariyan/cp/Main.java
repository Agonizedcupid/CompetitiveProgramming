package com.aariyan.cp;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] array = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(array)));
    }

    public static int[] sortedSquares(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);
        return nums;
    }
}
