import java.util.Scanner;

public class PrepandAppend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        while (testCase > 0) {
            int length = scanner.nextInt();
            String word = scanner.next();

            System.out.println(result(word.toCharArray(), length));

            testCase--;
        }
    }

    public static int result(char[] array, int length) {
        int startIndex = 0;
        int endIndex = length - 1;

        int answer = length;

        while (startIndex < endIndex) {

            if ((array[startIndex] == '1' && array[endIndex] == '0') || (array[startIndex] == '0' && array[endIndex] == '1')) {
                answer -= 2;
                startIndex++;
                endIndex--;
            } else {
                return answer;
            }

        }
        return answer;
    }
}
