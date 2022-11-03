package com.aariyan.cp;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int number = 10;
        System.out.println(listOfPrimes(number));
    }

    public static List<Integer> listOfPrimes(int number) {
        List<Integer> result = new ArrayList<>();
        boolean[] markerArray = new boolean[number + 1];
        for (int i = 0; i <= number; i++)
            markerArray[i] = true;

        int count = 0;
        for (int prime = 2; prime * prime <= number; prime++) {
            if (markerArray[prime]) {
                //let's cut all the gunoniyok:
                for (int gun = prime * prime; gun <= number; gun += prime) {
                    markerArray[gun] = false;
                    count ++;
                }
            }
        }

        for (int finalPrime = 2; finalPrime < number; finalPrime++) {
            if (markerArray[finalPrime])
                result.add(finalPrime);
        }

        System.out.println(markerArray.length + " - "+result.size() + " - "+count);
        return result;
    }

}
