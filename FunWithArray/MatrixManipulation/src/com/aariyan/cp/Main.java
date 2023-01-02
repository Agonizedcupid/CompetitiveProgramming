package com.aariyan.cp;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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


//            5 5 12 2 6
//                    7 4 2 3 4
//                    9 3 5 12 3
//                    7 2 6 7 2
//                    6 5 7 9 1

    public static int[][] matrix;
    public static int[] rowWiseMatrixSum, columnWiseMatrixSum;
    public static List<Integer> twoCrossTwoList = new ArrayList<>();
    public static int numberOfPerson, numberOfJobs;
    public static List<Integer> numberOfJobsFoundToComplete = new ArrayList<>();
    public static int firstBlockedRow = 0;
    public static int firstBlockedColumn = 0;
    public static int smallestNumberFromRestrictedRow = Integer.MAX_VALUE;
    public static int negateColumn = -1;
    public static int duplicateBiggestNumberCounter = 1;
    public static int biggestNumber = 0;
    public static int MIN_VAL = -0;
    public static int rowWiseTotalSumForDuplicateSmallestNumber = -1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rowOrColMaximum = 0;

        System.out.println("How many persons: ");
        numberOfPerson = input.nextInt();
        System.out.println("How many jobs: ");
        numberOfJobs = input.nextInt();
        rowWiseMatrixSum = new int[numberOfJobs];
        columnWiseMatrixSum = new int[numberOfJobs];

        System.out.println("Enter the matrix:");
        //int[][] matrix = new int[numberOfPerson][numberOfJobs];
        matrix = new int[numberOfPerson][numberOfJobs];
        for (int row = 0; row < numberOfJobs; row++) {
            for (int column = 0; column < numberOfPerson; column++) {
                matrix[row][column] = input.nextInt();
            }
        }

        findMatrixSum();

        //printing the matrix:
        printMatrix();

        //finding the biggest number in matrix:
        biggestNumber = findBiggestNumber();
        rowOrColMaximum = Math.max(numberOfJobs, numberOfPerson);
        runLoopToFindSimilarBiggestNumberEachOperation(rowOrColMaximum);
        negateRestrictedRow_N_Column();
        // When we have the Biggest & Smallest number, Now we will eliminate the Restricted row and column:
        int init = 0;
        System.out.println("Duplicate Biggest: " + duplicateBiggestNumberCounter);
        while (init < duplicateBiggestNumberCounter) {
            //negateRestrictedRow_N_Column();
            smallestNumberFromRestrictedRow = Integer.MAX_VALUE;
            runLoopToFindSimilarBiggestNumberEachOperation(rowOrColMaximum);
            negateRestrictedRow_N_Column();
            init++;
        }
        //negateSimilarBiggestNumbers(biggestNumber);
        System.out.println("Biggest: " + biggestNumber);
        //System.out.println("Result: " + numberOfJobsFoundToComplete.get(0));

        //printMatrix();

        // Finding the Matrix from Blocked Row:
        //findMinimumFromBlockedRow();
//
//        while (countMatrixDimension() > 4) {
//            // Second Cycle
//            secondCycle();
//            findMinimumFromBlockedRow();
//        }
//
//        twoCrossTwoMatrix();
//        int firstItem = twoCrossTwoList.get(0);
//        int secondItem = twoCrossTwoList.get(1);
//        int thirdItem = twoCrossTwoList.get(2);
//        int fourthItem = twoCrossTwoList.get(3);
//
//        int firstCrossTotal = firstItem + fourthItem;
//        int secondCrossTotal = secondItem + thirdItem;
//        if (firstCrossTotal < secondCrossTotal) {
//            if (firstItem < secondItem) {
//                System.out.println("Person ( " + (1) + " ) Completed : " + firstItem);
//                System.out.println("Person ( " + (2) + " ) Completed : " + fourthItem);
//            } else {
//                System.out.println("Person ( " + (1) + " ) Completed : " + fourthItem);
//                System.out.println("Person ( " + (2) + " ) Completed : " + firstItem);
//            }
//
//        } else {
////            System.out.println("Person ( "+(1) + " ) Completed : " + secondCrossTotal);
////            System.out.println("Person ( "+(2) + " ) Completed : " + firstCrossTotal);
//            if (secondItem < thirdItem) {
//                System.out.println("Person ( " + (1) + " ) Completed : " + secondItem);
//                System.out.println("Person ( " + (2) + " ) Completed : " + thirdItem);
//            } else {
//                System.out.println("Person ( " + (1) + " ) Completed : " + thirdItem);
//                System.out.println("Person ( " + (2) + " ) Completed : " + secondItem);
//            }
//        }
//        for (int index = 0; index < numberOfJobsFoundToComplete.size(); index++) {
//            System.out.println("Person ( " + (index + 3) + " ) Completed : " + numberOfJobsFoundToComplete.get(index));
//        }
    }

    private static void findMatrixSum() {
        // Row Wise:
        int sum;
        for (int row = 0; row < numberOfJobs; row++) {
            sum = 0;
            for (int column = 0; column < numberOfPerson; column++) {
                sum += matrix[row][column];
            }
            rowWiseMatrixSum[row] = sum;
        }
        System.out.println("ROW: " + Arrays.toString(rowWiseMatrixSum));
        //Column Wise Matrix Sum
        int summation;
        for (int row = 0; row < numberOfJobs; row++) {
            summation = 0;
            for (int column = 0; column < numberOfPerson; column++) {
                summation += matrix[column][row];
            }
            columnWiseMatrixSum[row] = summation;
        }
        System.out.println("Column: " + Arrays.toString(columnWiseMatrixSum));
    }

    private static void runLoopToFindSimilarBiggestNumberEachOperation(int rowOrColMaximum) {
        int in = 0;
        while (in < rowOrColMaximum) {
            smallestNumberFromRestrictedRow = findMinimumFromRestrictedRow();
            checkDuplicateBiggestNumber(biggestNumber);
            in++;
        }
    }

    private static int findMinimumFromRestrictedRow() {
        int minimum = smallestNumberFromRestrictedRow;
        for (int column = 0; column < numberOfPerson; column++) {
            int currentVal = matrix[firstBlockedRow][column];
            if (currentVal > 0) {
                if (currentVal < minimum) {
                    minimum = currentVal;
                    negateColumn = column;
                } else if (currentVal == minimum) { // if minimum value TIE
                    // If found the duplicate of smallest Number:
                    // if Row Wise
                    for (int col = 0; col < numberOfPerson; col++) {
                        if (matrix[firstBlockedRow][negateColumn] != minimum) {
                            if (matrix[firstBlockedRow][col] == minimum) {
                                int totalSum = rowWiseMatrixSum[col] - biggestNumber;
                                if (totalSum > rowWiseTotalSumForDuplicateSmallestNumber) {
                                    rowWiseTotalSumForDuplicateSmallestNumber = totalSum;
                                    //numberOfJobsFoundToComplete.add(matrix[firstBlockedRow][col]);
                                }
                            }
                        }
                    }

                    // if Column Wise
                }
            }
        }
        return minimum;
    }

//    private static int checkRowWiseDuplicate() {
//        // Find the column sum without biggest Number
//        int columnWiseSum = 0;
//        for (int column = 0; column < numberOfPerson; column++) {
//            if (matrix[firstBlockedRow][column] == biggestNumber) {
//
//            }
//        }
//    }

//    private static int checkColumnWiseDuplicate() {
//        // Find the Row sum without biggest Number
//        int rowWiseSum = 0;
//        for (int row = 0; column < numberOfPerson; column++) {
//            if (matrix[firstBlockedRow][column] == biggestNumber) {
//
//            }
//        }
//    }

    private static void checkDuplicateBiggestNumber(int biggestNumber) {
        int tempRow = firstBlockedRow;
        int tempColumn = firstBlockedColumn;
        duplicateBiggestNumberCounter = 0;
        for (int row = 0; row < numberOfJobs; row++) {
            for (int column = 0; column < numberOfPerson; column++) {
                if (row != firstBlockedRow && column != firstBlockedColumn) {
                    if (matrix[row][column] == biggestNumber && matrix[row][column] > 0) {
                        firstBlockedRow = row;
                        firstBlockedColumn = column;
                        duplicateBiggestNumberCounter++;
                        if (findMinimumFromRestrictedRow() < smallestNumberFromRestrictedRow) {
                            smallestNumberFromRestrictedRow = findMinimumFromRestrictedRow();
                            //matrix[tempRow][tempColumn] *= -1;
                        } else {
                            firstBlockedRow = tempRow;
                            firstBlockedColumn = tempColumn;
                        }
                    }
                }
            }
        }
    }

    private static void twoCrossTwoMatrix() {
        for (int row = 0; row < numberOfJobs; row++) {
            for (int column = 0; column < numberOfPerson; column++) {
                if (matrix[row][column] != MIN_VAL) {
                    twoCrossTwoList.add(matrix[row][column]);
                }
            }
        }
    }

    private static int countMatrixDimension() {
        int countDimension = 0;
        for (int row = 0; row < numberOfJobs; row++) {
            for (int column = 0; column < numberOfPerson; column++) {
                if (matrix[row][column] != MIN_VAL)
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
                if (currentVal != MIN_VAL) {
                    if (currentMinimum > currentVal) {
                        currentMinimum = currentVal;
                    }
                    firstBlockedRow = row;
                    firstBlockedColumn = column;
                }
            }
        }
    }

//    private static void findMinimumFromBlockedRow() {
//        int currentMin = Integer.MAX_VALUE;
//        int negateColumn = 0;
//        for (int column = 0; column < numberOfJobs; column++) {
//            //Finding the minimum from the Blocked row and negating all the elements from same row and column
//            if (currentMin > matrix[firstBlockedRow][column]) {
//                if (matrix[firstBlockedRow][column] != Integer.MIN_VALUE) {
//                    currentMin = matrix[firstBlockedRow][column];
//                    negateColumn = column;
//                }
//            }
//            matrix[firstBlockedRow][column] = Integer.MIN_VALUE; // it will negate the row
//        }
//        //it will negate the column:
//        for (int row = 0; row < numberOfPerson; row++) {
//            matrix[row][negateColumn] = Integer.MIN_VALUE;
//        }
//        numberOfJobsFoundToComplete.add(currentMin);
////        for (Integer index : numberOfJobsFoundToComplete) {
////            System.out.println("MIN: " + index);
////            // Now print Matrix:
////        }
//
//        printMatrix();
//
//    }

    private static void negateRestrictedRow_N_Column() {
        //int negateColumn = 0;
        for (int column = 0; column < numberOfJobs; column++) {
            //Finding the minimum from the Blocked row and negating all the elements from same row and column
            if (matrix[firstBlockedRow][column] != MIN_VAL) {
                //negateColumn = column;
                matrix[firstBlockedRow][column] = MIN_VAL; // it will negate the row
            }

        }
        //it will negate the column:
        for (int row = 0; row < numberOfPerson; row++) {
            if (matrix[row][negateColumn] != biggestNumber) {
                matrix[row][negateColumn] = MIN_VAL;
            }
        }
        // numberOfJobsFoundToComplete.add(smallestNumberFromRestrictedRow);
//        for (Integer index : numberOfJobsFoundToComplete) {
//            System.out.println("MIN: " + index);
//            // Now print Matrix:
//        }

        printMatrix();
    }

//    private static void negateSimilarBiggestNumbers(int biggestNumber) {
//        for (int row = 0; row < numberOfJobs; row++) {
//            for (int column = 0; column < numberOfPerson; column++) {
//                if (matrix[row][column] == biggestNumber) {
//                    matrix[row][column] = Integer.MIN_VALUE;
//                }
//            }
//        }
//    }

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
        //matrix[firstBlockedRow][firstBlockedColumn] = Integer.MIN_VALUE;
        matrix[firstBlockedRow][firstBlockedColumn] *= -1;
        return max;
    }
}
