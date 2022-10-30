import java.util.Arrays;

public class Orray {

    public static void main (String[] args) {

        //int[] array = {1, 2, 4, 8,}; //8 4 2 1
        int[] array = {1, 3, 7, 15};
            System.out.println(1|3);
        orOperation(array);
    }

    public static void orOperation (int[] array) {
        //int[] array = new int[];
        for (int i=0; i<array.length-1; i++) {
            array[i] = array[i] | array[i+1];
        }
        array[array.length-1] = array[array.length - 1] | array[array.length - 2];

        System.out.println(Arrays.toString(array));
    }
}
