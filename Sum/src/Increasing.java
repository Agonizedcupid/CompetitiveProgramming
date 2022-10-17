import java.util.Arrays;
import java.util.Scanner;

public class Increasing {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        int [] array;
        while (testCase != 0) {
            int n = scanner.nextInt();
            array = new int[n];
            for (int i=0; i<n; i++) {
                array[i] = scanner.nextInt();
            }
            System.out.println(isIncreasing(n, array));
            testCase --;
        }

    }

    public static String isIncreasing (int n , int[] array) {
        if (n == 1) {
            return "YES";
        }
        Arrays.sort(array);
        boolean flag = false;
        for (int i=0; i<n-1; i++) {
            if (array[i] < array[i+1]) {
                flag = true;
            } else {
                return "NO";
            }
        }
        if (flag) {
            return "YES";
        } else {
            return "NO";
        }

    }
}
