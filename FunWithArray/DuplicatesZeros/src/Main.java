import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 0, 2, 3, 0, 4, 5, 0};
        System.out.println(Arrays.toString(duplicateZeros(array)));

        System.out.println(3/(double)2);
    }

    public static int[] duplicateZeros(int[] array) {
        int startIndex = 0;
        while (startIndex < array.length) {
            if (array[startIndex] == 0) {
                shiftElementToRight(startIndex, array);
                startIndex += 2;
            } else {
                startIndex++;
            }
        }
        return array;
    }

    public static void shiftElementToRight(int startPosition, int[] array) {
        int lastIndex = array.length - 2;
        while (lastIndex > startPosition) {
            array[lastIndex + 1] = array[lastIndex];
            lastIndex--;
        }
        //1,0,2,3,0,4,5,0
        System.out.println(lastIndex);
        if (lastIndex < array.length - 1)
            array[lastIndex + 1] = 0;
    }
}