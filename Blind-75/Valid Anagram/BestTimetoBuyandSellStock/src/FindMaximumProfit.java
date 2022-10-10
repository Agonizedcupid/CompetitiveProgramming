public class FindMaximumProfit {
    public static void main(String[] args) {
        int[] array = {7, 1, 5, 3, 6, 4};
        //int[] array = {7,6,4,3,1};
        System.out.println(maxProfit(array));
    }

    public static int maxProfit(int[] array) {

        if (array.length <= 1) return 0;

        int index = 0;
        int last = Integer.MAX_VALUE;
        int lastSell = Integer.MIN_VALUE;
        int current;
        int sell;

        while (index < array.length) {
            current = array[index];
            if (current < last) {
                last = current; // 1
            } //7, 1, 5, 3, 6, 4
            else {
                sell = current - last;
                if (sell > lastSell) {
                    lastSell = sell;
                }
            }

            index++;
        }
        if (lastSell <= 0) {
            return 0;
        } else {
            return lastSell;
        }

    }
}
