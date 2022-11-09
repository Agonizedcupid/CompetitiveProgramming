import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {1,0,2,3,0,4,5,0};
        System.out.println(Arrays.toString(duplicateZeros(array)));
    }

    public static int[] duplicateZeros(int[] array) {
        for (int i=0; i<array.length; i++) {
            if (array[i] == 0) {
                shiftElementToRight(i,array);
            }
        }
        return array;
    }

    public static void shiftElementToRight(int startPosition, int[] array) {
        int lastIndex = array.length - 2;
        while (lastIndex > startPosition + 1) {
            array[lastIndex + 1] = array[lastIndex];
            lastIndex --;
        }
        //1,0,2,3,0,4,5,0
        System.out.println(lastIndex);
        array[lastIndex] = 0;
    }
}