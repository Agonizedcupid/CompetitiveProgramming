import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] array = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = arrayManipulation(array);
        for (Integer value : result) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static List<Integer> arrayManipulation(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) { // just negating the values:
            int valueAsIndex = nums[i];
            if (nums[Math.abs(valueAsIndex) - 1] > 0) {
                nums[Math.abs(valueAsIndex) - 1] = -nums[Math.abs(valueAsIndex) - 1];
            }
        }

        for (int index = 1; index <= nums.length; index++) {
            if (nums[index - 1] > 0) result.add(index);
        }

        return result;
    }
}