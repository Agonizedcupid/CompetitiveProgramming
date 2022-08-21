import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       // int[] array = {1, 2, 3, 7, 5};
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int target = 15;
        List<Integer> list = findSubArrayToSum(array, array.length, target);

        System.out.println(Arrays.toString(list.toArray()));
    }

    public static List<Integer> findSubArrayToSum(int[] array, int size, int target) {
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        for (int i = 0, j = 0; i < size; i++) {
            //{1, 2, 3, 7, 5}
            sum += array[i];
            if (sum > target) {
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