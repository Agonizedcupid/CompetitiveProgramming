package com.aariyan.cp;

import javax.imageio.ImageTranscoder;
import javax.swing.*;
import java.util.*;

public class TestClass {
    //    public static int[][] matrix = {{1, 2, 3},
//            {4, 5, 6}};
//    public static int[][] matrix = {
//            {1, 2},
//            {3, 4},
//            {5, 6}};
    public static Map<String, Integer> map = new HashMap<>();
    public static int[][] matrix = {
            {0, 0, 0, 0, 0},
            {7, 0, 2, 0, 0},
            {0, 0, 0, 0, 0},
            {7, 0, 6, 0, 0},
            {0, 0, 0, 0, 0}
    };
    public static int numberOfJobs = 5;
    public static int numberOfPerson = 5;
    public static int firstValueChecker = 0;
    public static int secondValueChecker = 0;
    public static int minVal = Integer.MAX_VALUE;

//    public static void main(String[] args) {
//        int numberOfJobs = 5;
//        int numberOfPerson = 5;
//
//
//        int column1 = 0;
//        int column2 = 0;
//        int row = 1;
//        int takenColumn = -1;
//        int sum = 0;
//
//        int firstVal = 0;
//
////        while (column1 < numberOfJobs) {
////            firstVal = getFirstVal(column1,row-1);
////            while (column2 < numberOfJobs) {
////                if (column2 != column1) {
////                    sum = firstVal + matrix[row][column2];
////                    System.out.println(sum);
////                }
////                column2++;
////            }
////            column2 = 0;
////            row ++;
////            column1++;
////        }
//        int flag = 1;
//        while (column1 < numberOfPerson) {
//            if (matrix[column1][row - 1] == 0) {
//                column1 ++;
//                continue;
//            }
//            while (row <= numberOfJobs && flag < numberOfPerson) {
//                firstVal = getFirstVal(column1, row - 1);
//                System.out.println("FirstVal: " + firstVal);
//                while (column2 < numberOfJobs) {
//                    if (column2 != row - 1) {
//                        sum = firstVal + matrix[flag][column2];
//                        System.out.println(sum);
//                    }
//                    column2++;
//                }
//                column2 = 0;
//                row++;
//            }
//            flag++;
//            row = 0;
//            column1++;
//        }
//    }


    public static void main(String[] args) {
//        int principal = 0, secondary = 0;
//        for (int i = 0; i < n; i++) {
//            principal += mat[i][i];
//            secondary += mat[i][n - i - 1];
//        }

//        int r = 0, c = 0;
//        boolean flag = false;
//        //checking 0 rows & column:
//        for (int row = 0; row < numberOfPerson; row++) { // row wise
//            flag = false;
//            for (int column = 0; column < numberOfJobs; column++) {
//                if (matrix[row][column] != 0) {
//                    flag = true;
//                    break;
//                }
//            }
//            r = row;
//            if (!flag) {
//                rowWiseZero(r);
//            }
//
//        }
//
//        flag = false;
//        for (int row = 0; row < numberOfPerson; row++) { // row wise
//            flag = false;
//            for (int column = 0; column < numberOfPerson; column++) {
//                if (matrix[column][row] <= 0) {
//                    flag = true;
//                    break;
//                }
//                c = column;
//            }
//            if (!flag)
//                columnWiseZero(c);
//        }
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < numberOfPerson; i++) {
            resultList.add("I'm the best, No Work!");
        }
        for (int row = 0; row < numberOfPerson; row++) {
            for (int column = 0; column < numberOfJobs; column++) {
                if (matrix[row][column] != 0) {
                    map.put(row + "-" + column, matrix[row][column]);
                }
            }
        }
        for (Map.Entry<String, Integer> val : map.entrySet()) {
            //System.out.print(val.getKey() + " == " + val.getValue() + "\n");
            String singleCode = val.getKey();
            int value = val.getValue();
            String[] splitRes = singleCode.split("-");
            int sum = 0;
            int temp = 0;
            for (Map.Entry<String, Integer> button : map.entrySet()) {
                if (!button.getKey().contains(splitRes[0]) && !button.getKey().contains(splitRes[1])) {
                    sum = value + button.getValue();
                    String[] t = button.getKey().split("-");
                    temp = Integer.parseInt(t[0]);
                }
            }
            if (sum < minVal) {
                minVal = sum;
                firstValueChecker = Integer.parseInt(splitRes[0]);
                secondValueChecker = temp;
            }
            //System.out.println(sum);
        }
        resultList.add(firstValueChecker, "" + firstValueChecker);
        resultList.add(secondValueChecker, "" + secondValueChecker);

        for (String index : resultList) {
            System.out.println(index);
        }
    }

//    public static void rowWiseZero(int row) {
//        for (int column = 0; column < numberOfJobs; column++) {
//            matrix[row][column] = -1;
//        }
//    }
//
//    public static void columnWiseZero(int column) {
//        for (int row = 0; row < numberOfPerson; row++) {
//            matrix[row][column] = -2;
//        }
//    }

//    private static void printMatrix() {
//        for (int row = 0; row < numberOfPerson; row++) {
//            for (int column = 0; column < numberOfJobs; column++) {
//                System.out.print(matrix[row][column] + "    ");
//            }
//            System.out.println();
//        }
//    }

//    public static int getFirstVal(int row, int column) {
//        return matrix[row][column];
//    }
}
