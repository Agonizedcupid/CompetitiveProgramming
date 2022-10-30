import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        //long summation = 0;
        while (testCase != 0) {
            int length = scanner.nextInt();
            int query = scanner.nextInt();

            int[] array = new int[length];

            long resultantSum = 0;

            int totalOddCount = 0;
            int totalEvenCount = 0;

            for (int i = 0; i < length; i++) {
                array[i] = scanner.nextInt();
                if (array[i] % 2 != 0) totalOddCount++;
                else totalEvenCount++;

                resultantSum += array[i];
            }
            for (int j = 0; j < query; j++) {
                int first = scanner.nextInt();
                int last = scanner.nextInt();

                if (first == 0) { // add to EVEN
                    if (last % 2 == 0) {
                        resultantSum += (long) totalEvenCount * last;
                    } else {
                        resultantSum += (long) totalEvenCount * last;
                        totalEvenCount = 0;
                        totalOddCount = length;
                    }
                } else { //add to ODD
                    if (last % 2 == 0) {
                        resultantSum += (long) totalOddCount * last;
                    } else {
                        resultantSum += (long) totalOddCount * last;
                        totalOddCount = 0;
                        totalEvenCount = length;
                    }
                }

                System.out.println(resultantSum);

//                for (int i = 0; i < query; i++) {
//
//                    //summation += array[i];
//                }

                //System.out.println(maximumSum(length, array, query, first, last, totalEvenCount, totalOddCount, resultantSum));
            }

            testCase--;
        }
    }

    //firstQ == 0 add EVEN
    //firstQ == 1 add ODD
    public static long maximumSum(int length, int[] array, int query, int firstQ, int lastQ, int totalEvenCount, int totalOddCount, long summation) {
        for (int i = 0; i < query; i++) {
            if (firstQ == 0) { // add to EVEN
                if (lastQ % 2 == 0) {
                    summation += (long) totalEvenCount * lastQ;
                } else {
                    summation += (long) totalEvenCount * lastQ;
                    totalEvenCount = 0;
                    totalOddCount = length;
                }
            } else { //add to ODD
                if (lastQ % 2 == 0) {
                    summation += (long) totalOddCount * lastQ;
                } else {
                    summation += (long) totalOddCount * lastQ;
                    totalOddCount = 0;
                    totalEvenCount = length;
                }
            }
            //summation += array[i];
        }
        return summation;
    }
}
