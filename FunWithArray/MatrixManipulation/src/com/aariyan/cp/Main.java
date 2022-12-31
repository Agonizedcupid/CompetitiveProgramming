package com.aariyan.cp;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /**
     * 9 11 10 17
     * 12 9 10 9
     * 20 11 14 7
     * 14 8 7 8
     */
//     9 11 10 17
//             12 9 10 9
//             20 11 14 7
//             14 8 7 8
    public static int[][] matrix;
    public static List<Integer> twoCrossTwoList = new ArrayList<>();
    public static int numberOfPerson, numberOfJobs;
    public static List<Integer> numberOfJobsFoundToComplete = new ArrayList<>();
    public static int firstBlockedRow = 0;
    public static int firstBlockedColumn = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("How many persons: ");
        numberOfPerson = input.nextInt();
        System.out.println("How many jobs: ");
        numberOfJobs = input.nextInt();

        System.out.println("Enter the matrix:");
        //int[][] matrix = new int[numberOfPerson][numberOfJobs];
        matrix = new int[numberOfPerson][numberOfJobs];
        for (int row = 0; row < numberOfJobs; row++) {
            for (int column = 0; column < numberOfPerson; column++) {
                matrix[row][column] = input.nextInt();
            }
        }

        //printing the matrix:
        printMatrix();

        //finding the biggest number in matrix:
        int biggestNumber = findBiggestNumber();
        negateSimilarBiggestNumbers(biggestNumber);
        System.out.println("Biggest: " + biggestNumber);

        printMatrix();

        // Finding the Matrix from Blocked Row:
        findMinimumFromBlockedRow();

        while (countMatrixDimension() > 4) {
            // Second Cycle
            secondCycle();
            findMinimumFromBlockedRow();
        }

        twoCrossTwoMatrix();
        int firstItem = twoCrossTwoList.get(0);
        int secondItem = twoCrossTwoList.get(1);
        int thirdItem = twoCrossTwoList.get(2);
        int fourthItem = twoCrossTwoList.get(3);

        int firstCrossTotal = firstItem + fourthItem;
        int secondCrossTotal = secondItem + thirdItem;
        if (firstCrossTotal < secondCrossTotal) {
            System.out.println("Person ( "+(1) + " ) Completed : " + firstCrossTotal);
            System.out.println("Person ( "+(2) + " ) Completed : " + secondCrossTotal);
        } else {
            System.out.println("Person ( "+(1) + " ) Completed : " + secondCrossTotal);
            System.out.println("Person ( "+(2) + " ) Completed : " + firstCrossTotal);
        }
        for (int index = 0; index < numberOfJobsFoundToComplete.size(); index ++) {
            System.out.println("Person ( "+(index + 3) + " ) Completed : " + numberOfJobsFoundToComplete.get(index));
        }
    }

    private static void twoCrossTwoMatrix() {
        for (int row = 0; row < numberOfJobs; row ++) {
            for (int column = 0; column < numberOfPerson; column ++) {
                if (matrix[row][column] != Integer.MIN_VALUE) {
                    twoCrossTwoList.add(matrix[row][column]);
                }
            }
        }
    }

    private static int countMatrixDimension() {
        int countDimension = 0;
        for (int row = 0; row < numberOfJobs; row++) {
            for (int column = 0; column < numberOfPerson; column++) {
                if (matrix[row][column] != Integer.MIN_VALUE)
                    countDimension++;
            }
        }
        return countDimension;
    }

    private static void secondCycle() {
        int currentMinimum = Integer.MAX_VALUE;
        for (int row = 0; row < numberOfJobs; row++) {
            for (int column = 0; column < numberOfPerson; column++) {
                int currentVal = matrix[row][column];
                if (currentVal != Integer.MIN_VALUE) {
                    if (currentMinimum > currentVal) {
                        currentMinimum = currentVal;
                    }
                    firstBlockedRow = row;
                    firstBlockedColumn = column;
                }
            }
        }
    }

    private static void findMinimumFromBlockedRow() {
        int currentMin = Integer.MAX_VALUE;
        int negateColumn = 0;
        for (int column = 0; column < numberOfJobs; column++) {
            //Finding the minimum from the Blocked row and negating all the elements from same row and column
            if (currentMin > matrix[firstBlockedRow][column]) {
                if (matrix[firstBlockedRow][column] != Integer.MIN_VALUE) {
                    currentMin = matrix[firstBlockedRow][column];
                    negateColumn = column;
                }
            }
            matrix[firstBlockedRow][column] = Integer.MIN_VALUE; // it will negate the row
        }
        //it will negate the column:
        for (int row = 0; row < numberOfPerson; row++) {
            matrix[row][negateColumn] = Integer.MIN_VALUE;
        }
        numberOfJobsFoundToComplete.add(currentMin);
//        for (Integer index : numberOfJobsFoundToComplete) {
//            System.out.println("MIN: " + index);
//            // Now print Matrix:
//        }

        printMatrix();

    }

    private static void negateSimilarBiggestNumbers(int biggestNumber) {
        for (int row = 0; row < numberOfJobs; row++) {
            for (int column = 0; column < numberOfPerson; column++) {
                if (matrix[row][column] == biggestNumber) {
                    matrix[row][column] = Integer.MIN_VALUE;
                }
            }
        }
    }

    private static void printMatrix() {
        for (int i = 0; i < numberOfJobs; i++) {
            if (i == 0) {
                System.out.print("                    Jobs ( " + (i + 1) + " )        ");
            } else {
                System.out.print("        Jobs ( " + (i + 1) + " )        ");
            }
        }
        System.out.println();
        for (int row = 0; row < numberOfJobs; row++) {
            System.out.print("Person ( " + (row + 1) + " )        ");
            for (int column = 0; column < numberOfPerson; column++) {
                System.out.print(matrix[row][column] + "                        ");
            }
            System.out.println();
        }
    }

    public static int findBiggestNumber() {
//        // Handling the base cases
//        if (column == matrix[0].length && row < matrix.length) {
//
//            // Changing the row and column index
//            column = 0;
//            ++row;
//        }
//
//        // Generic case
//        if (row == matrix.length) {
//            // Simply return
//            return 0;
//        }
//
//        // By far if we reach here then
//        // return the max element
//        int currentResult = matrix[row][column];
//        int recursiveResult = findBiggestNumber(row, column + 1);
//        if (currentResult > recursiveResult) {
//            //matrix[row][column] = Integer.MIN_VALUE;
//            //printMatrix();
//            System.out.println("R&C: "+ row +" -> "+column);
//            return currentResult;
//        } else {
//            //matrix[row][column] = Integer.MIN_VALUE;
//            //printMatrix();
//            return recursiveResult;
//        }
//        //return Math.max(currentResult, recursiveResult);
        int max = 0;
        //int row = 0, column = 0;

        // Iterating over matrix
        // using nested for loops

        // Outer loop for rows
        for (int i = 0; i < matrix.length; ++i) {

            // Inner loop for columns
            for (int j = 0; j < matrix[0].length; ++j) {

                // Storing the maximum element
                int currentElement = matrix[i][j];
                if (currentElement > max) {
                    firstBlockedRow = i;
                    firstBlockedColumn = j;
                    max = currentElement;
                }
            }
        }

        // Return the maximum element
        matrix[firstBlockedRow][firstBlockedColumn] = Integer.MIN_VALUE;
        return max;
    }
}
