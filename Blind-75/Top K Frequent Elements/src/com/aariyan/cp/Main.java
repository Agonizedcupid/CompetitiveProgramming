package com.aariyan.cp;

import java.util.Arrays;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 1, 1, 2, 3, 4, 4, 4, 4, 5, 5};
        int k = 3;
        System.out.println(Arrays.toString(topKFrequent(array, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }


        for(Integer key : map.descendingKeySet()){
            System.out.println("value of " + key + " is " + map.get(key));
        }
        return null;
    }

}
