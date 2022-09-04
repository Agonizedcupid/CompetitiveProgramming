package com.aariyan.cp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Time : O(N) <p>
 * Space: O(N)
 */

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(findUnique(array));
    }

    public static boolean findUnique(int[] array) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (!hashSet.isEmpty() & hashSet.contains(array[i])) {
                return true;
            } else {
                hashSet.add(array[i]);
            }
        }
        return false;
    }
}
