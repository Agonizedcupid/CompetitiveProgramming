public class C {

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 3, 3, 5};
        System.out.println(maximizeWin(array, 2));
    }

    public static int maximizeWin(int[] array, int k) {
        int constant = 2;
        for (int index = array.length - 1; index >= 0; index --) {
            while (constant > 0) {

                while (k > 0) {

                    k --;
                }

                constant --;
            }
        }

    }
}
