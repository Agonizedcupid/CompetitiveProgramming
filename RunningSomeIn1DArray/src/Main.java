import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] array = {3,1,2,10,1};
        System.out.println(Arrays.toString(runningSum(array)));
    }

    public static int[] runningSum(int[] nums) {
        for (int i=1; i<nums.length; i++) {
            nums[i] = nums[i-1]+nums[i];
        }

        return nums;
    }
}