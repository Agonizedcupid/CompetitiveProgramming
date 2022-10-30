public class Main {
    public static void main(String[] args) {
        //int[] array = {7, 1, 5, 3, 6, 4};
        //int[] array = {1, 2, 3, 4, 5};
        int[] array = {1, 7, 2, 3, 6, 7, 6, 7};
        System.out.println(maxProfit(array));
    }


    public static int maxProfit(int[] array) {
        int maxProfit = 0;

        for (int i=1; i<array.length; i++) {
            if (array[i-1] < array[i]) {
                maxProfit += array[i] - array[i-1];
            }
        }

        return maxProfit;
    }
}