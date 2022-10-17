import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String letters = "3377";
        List<String> list = generateAllPermutation(0, letters);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static List<String> generateAllPermutation(int recursionPosition, String letters) {
        List<String> answer = new ArrayList<>();
        findPermutation(recursionPosition, letters, answer);
        return answer;
    }

    public static void findPermutation(int position, String letters, List<String> list) {

        if (position == letters.length()) {
            list.add(letters);
            //System.out.println(letters);
        } else {
            for (int i = position; i < letters.length(); i++) {
                letters = swapping(position, i, letters);
                findPermutation(position + 1, letters, list);
                letters = swapping(position, i, letters);
            }
        }
    }

    private static String swapping(int position, int loopPosition, String letters) {
        char[] array = letters.toCharArray();
        char temp = array[loopPosition];
        array[loopPosition] = array[position];
        array[position] = temp;
        return String.valueOf(array);
    }
}