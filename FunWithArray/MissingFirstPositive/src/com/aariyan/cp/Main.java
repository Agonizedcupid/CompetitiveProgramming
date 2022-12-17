package com.aariyan.cp;

public class Main {

    public static void main(String[] args) {

        int[] array = {1};
        System.out.println(missingFirstPositive(array));

    }

    public static int missingFirstPositive(int[] array) {
        // marking the negative value as 0
        for (int index = 0; index < array.length; index++) {
            if (array[index] < 0) array[index] = 0;
        }

        //Traversing and marking as Negative by index:
        for (int index = 0; index < array.length; index++) {
            int value = Math.abs(array[index]);
            //check the Bounce:
            if (value >= 1 && value <= array.length) {
                if (array[value - 1] > 0) { // value - 1 means finding the actual index corresponding to the value
                    array[value - 1] *= -1;
                } else if (array[value - 1] == 0) {
                    array[value - 1] = -1 * (array.length + 1);
                }
            }
        }

        //Finally, finding the value corresponding to the index:
        for (int index = 1; index <= array.length; index ++) {
            if (array[index - 1] >= 0) { // it means this is the missing integer corresponding to the index:
                return index;
            }
        }
        return array.length + 1;
    }
}
