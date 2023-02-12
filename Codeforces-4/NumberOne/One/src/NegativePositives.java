import org.omg.CORBA.MARSHAL;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class NegativePositives {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        while (testCase > 0) {
            int l = scanner.nextInt();
            long[] array = new long[l];
            long sum = 0;
            int flag = 0;
            long countNegative = 0;
            for (int index = 0; index < l; index++) {
                array[index] = scanner.nextInt();
                sum += Math.abs(array[index]);
                if (array[index] < 0) {
                    countNegative++;
                }
            }
            if (countNegative % 2 == 0) {
                System.out.println(sum);
            } else {
                System.out.println(maxVal(array, sum, countNegative));
            }
            testCase--;
        }
    }

    public static long maxVal(long[] array, long sum, long negative) {
//        int index = 1;
//        int last = Integer.MIN_VALUE, next = Integer.MIN_VALUE;
//
//        int newSum = 0;
//        while (index < array.length) {
//
//            last = array[index - 1];
//            if (index < array.length - 1) {
//                next = array[index + 1];
//            } else {
//                next = Integer.MIN_VALUE;
//            }
//
//            if (array[index] <= 0) {
//                int tempSum;
//                if (next == Integer.MIN_VALUE) {
//                    tempSum = Math.max((newSum + last),(newSum + Math.abs(array[index])));
//                    newSum = Math.max(newSum, tempSum);
//                } else {
//                    int mainSum = newSum + Math.abs(array[index]);
//                    int p = (newSum + last);
//                    int n = (newSum + next);
//                    mainSum = Math.max(mainSum, p);
//                    mainSum = Math.max(mainSum, n);
//                    newSum = Math.max(mainSum, newSum);
//                }
//            } else {
//                newSum += array[index - 1];
//            }
//            index++;
//        }
//
//        return Math.max(sum, newSum);

        for (int index = 0; index < array.length; index++) {
            if (array[index] < 0) {
                array[index] = Math.abs(array[index]);
            }
        }
        Arrays.sort(array);
        return (long) (sum - (array[0] * 2));
    }
}
