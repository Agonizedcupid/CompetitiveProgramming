import java.util.Scanner;

public class FollowingDirections {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        while (testCase > 0) {
            int l = scanner.nextInt();
            //char[] array = new char[l];
            String word = scanner.next();
//            for (int index = 0; index < l; index ++) {
//                array[index] = scanner.next().charAt(0);
//            }
            System.out.println(isCrossed(word.toCharArray()));
            testCase--;
        }
    }

    public static String isCrossed(char[] array) {
        int [] check = {0,0};

        for (int index = 0; index < array.length; index ++) {
            if (array[index] == 'U') {
                check[0] = check[0] + 1;
            }
            if (array[index] == 'R') {
                check[1] = check[1] + 1;
            }
            if (array[index] == 'D') {
                check[0] = check[0] - 1;
            }
            if (array[index] == 'L') {
                check[1] = check[1] - 1;
            }
            if (check[0] == 1 && check[1] == 1) {
                return "YES";
            }
        }
        return "NO";
    }
}
