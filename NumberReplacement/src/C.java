import java.util.Map;
import java.util.Scanner;

public class C {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        while (testCase != 0) {
            int length = scanner.nextInt();
            String symbol = scanner.next();
            String words = scanner.next();

            System.out.println(second(length, symbol, words));

            testCase --;
        }
    }

    public static int second(int length, String symbol, String words) {
        int max = 0;
        int count = 0;
        for (int i=0; i<length; i++) {
            char current = words.charAt(i);
            if (String.valueOf(current).equals(symbol) && !String.valueOf(current).equals("g")) {
                count++;
            } else {

            }
        }
    }
}
