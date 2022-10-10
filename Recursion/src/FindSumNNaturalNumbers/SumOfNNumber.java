package FindSumNNaturalNumbers;

public class SumOfNNumber {
    public static void main(String[] args) {
        int number = 100;
        System.out.println(findSumTillNumber(number));
    }

    public static int findSumTillNumber(int number) {
        if (number == 1) return 1;
        return number + findSumTillNumber(number - 1);
    }
}
