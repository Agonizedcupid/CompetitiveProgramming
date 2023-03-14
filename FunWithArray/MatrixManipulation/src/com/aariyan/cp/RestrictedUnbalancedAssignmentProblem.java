package com.aariyan.cp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestrictedUnbalancedAssignmentProblem {
    public static void main(String[] args) {
        int[][] costMatrix = {
                {4, 6, 10, 5, 6},
                {7, 4, 20, 5, 4},
                {20, 6, 9, 6, 2},
                {9, 3, 7, 2, 3}
        };
        int numWorkers = costMatrix.length;
        int numJobs = costMatrix[0].length;
        int[] allocatedJobs = new int[numWorkers]; // to store the job allocated to each worker
        boolean[] markedWorkers = new boolean[numWorkers]; // to keep track of marked workers
        boolean[] markedJobs = new boolean[numJobs]; // to keep track of marked jobs

        // Iteration 1: mark the rows having exactly one unmarked zero
        for (int i = 0; i < numWorkers; i++) {
            int countUnmarkedZeros = 0;
            int unmarkedZeroIndex = -1;
            for (int j = 0; j < numJobs; j++) {
                if (costMatrix[i][j] == 0 && !markedJobs[j]) {
                    countUnmarkedZeros++;
                    unmarkedZeroIndex = j;
                }
            }
            if (countUnmarkedZeros == 1) {
                allocatedJobs[i] = unmarkedZeroIndex;
                markedWorkers[i] = true;
                markedJobs[unmarkedZeroIndex] = true;
            }
        }

        // Iteration 2: mark the rows having minimum unmarked value
        for (int i = 0; i < numWorkers; i++) {
            if (!markedWorkers[i]) {
                int minUnmarkedValue = Integer.MAX_VALUE;
                for (int j = 0; j < numJobs; j++) {
                    if (costMatrix[i][j] < minUnmarkedValue && !markedJobs[j]) {
                        minUnmarkedValue = costMatrix[i][j];
                    }
                }
                for (int j = 0; j < numJobs; j++) {
                    if (costMatrix[i][j] == minUnmarkedValue) {
                        allocatedJobs[i] = j;
                        markedJobs[j] = true;
                        break;
                    }
                }
            }
        }

        // Iteration 3: if necessary, mark the columns having exactly one marked zero
        for (int j = 0; j < numJobs; j++) {
            int countMarkedZeros = 0;
            int markedZeroIndex = -1;
            for (int i = 0; i < numWorkers; i++) {
                if (costMatrix[i][j] == 0 && markedWorkers[i]) {
                    countMarkedZeros++;
                    markedZeroIndex = i;
                }
            }
            if (countMarkedZeros == 1) {
                allocatedJobs[markedZeroIndex] = j;
                markedJobs[j] = true;
            }
        }

        // print the allocated jobs and minimum cost
        int minCost = 0;
        for (int i = 0; i < numWorkers; i++) {
            int jobIndex = allocatedJobs[i];
            minCost += costMatrix[i][jobIndex];
            //System.out.println("Worker " + (i + 1) + " is allocated to job " + (jobIndex + 1));
            System.out.println("Worker " + (i + 1) + " is allocated to job " + costMatrix[i][jobIndex]);
        }
        System.out.println("Minimum cost = " + minCost);
    }
}


