import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array = {1, 7, 3, 6, 5, 6};
        //int[] array = {1, 2, 3};
        //int[] array = {2, 1, -1};
        System.out.println(pivotIndex(array));
    }

    public static int pivotIndex(int[] nums) {

        int totalSum = 0;
        int leftSum = 0;
        for (Integer numbers : nums) totalSum += numbers;

        for (int i = 0; i<nums.length; i++) {
            int rightSum = leftSum + nums[i];
            if (leftSum == totalSum - rightSum) return i;
            leftSum += nums[i];
        }

        return -1;
    }
}