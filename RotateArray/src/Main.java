import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {-1};
        int k = 2;
        if (array.length < k ) k = k % array.length;
        System.out.println(k);
        //First Rotate k element;
        rotateArray(array, array.length - k, array.length - 1);
        //rotate first to before k elements:
        rotateArray(array, 0, (array.length - 1) -k);
        //then reverse whole array:
        rotateArray(array, 0, array.length-1);

        System.out.println(Arrays.toString(array));
    }

    public static int[] rotateArray(int[] array, int startIndex, int lastIndex) {
        while (startIndex < lastIndex) {
            int temp = array[startIndex];
            array[startIndex] = array[lastIndex];
            array[lastIndex] =temp;
            startIndex ++;
            lastIndex --;
        }

        return array;
    }
}