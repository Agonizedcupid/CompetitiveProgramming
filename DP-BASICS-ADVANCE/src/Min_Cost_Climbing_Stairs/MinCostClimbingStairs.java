package Min_Cost_Climbing_Stairs;

import java.util.Arrays;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        //int[] array = {10,15,20};
        //int[] array = {0,1,1,0}; //Result: [0, 1, 0, 0]
        int[] array = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minimumCost(array));
    }

//    public static int minimumCost(int[] array) {
//
//        int lastVal = array[array.length - 1];
//        array[array.length - 1] = lastVal;
//        int secondLast = Math.min(array[array.length - 1] + lastVal, array[array.length - 2]);
//        array[array.length - 2] = secondLast;
//
//        for (int i = array.length - 3; i >= 0; i--) {
//            int temp = secondLast;
//            secondLast = Math.min(array[i] + secondLast, array[i] + lastVal);
//            array[i] = secondLast;
//            lastVal = temp;
//        }
//        System.out.println(Arrays.toString(array));
//        return Math.min(array[0], array[1]);
//    }

    public static int minimumCost(int[] array) {

//        int lastVal = array[array.length - 1];
//        array[array.length - 1] = lastVal;
//        int secondLast = Math.min(array[array.length - 1] + lastVal, array[array.length - 2]);
//        array[array.length - 2] = secondLast;
        //0,1,1,0
        for (int i = array.length - 3; i >= 0; i--) {
            array[i] = Math.min(array[i] + array[i+1], array[i] + array[i+2]);
        }
        System.out.println(Arrays.toString(array));
        return Math.min(array[0], array[1]);
    }
}
