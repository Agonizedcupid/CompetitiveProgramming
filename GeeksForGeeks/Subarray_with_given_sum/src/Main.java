import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         int[] array = {1,8};
        int target = 8;
        List<Integer> list = findSubArrayToSum(array, array.length, target);

        System.out.println(Arrays.toString(list.toArray()));
    }

    public static List<Integer> findSubArrayToSum(int[] array, int size, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        int sum = array[0];
        for (int i = 1, j = 0; i < size; i++) {
            //{1, 2, 3, 7, 5}

            sum += array[i];
            while (sum > target) {
                System.out.println(sum);
                sum -= array[j];
                j++;
            }
            if (sum == target) {
                result.add(j + 1);
                result.add(i + 1);
                return result;
            }

        }
        result.add(-1);
        return result;
    }
}