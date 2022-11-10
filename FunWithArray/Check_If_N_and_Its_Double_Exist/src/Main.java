import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] array = {3,1,7,11};
        System.out.println(checkIfExist(array));
    }

    public static boolean checkIfExist(int[] arr) {
        int startIndex = 0;
        Set<Integer> set = new HashSet<>();
        while (startIndex < arr.length) {
            if (!set.isEmpty() && set.contains(2 * arr[startIndex]) || ( arr[startIndex] % 2 == 0 && set.contains(arr[startIndex] / 2))) {
                return true;
            }
            set.add(arr[startIndex]);
            startIndex++;
        }
        return false;
    }
}