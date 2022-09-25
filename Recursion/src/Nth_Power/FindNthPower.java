package Nth_Power;

public class FindNthPower {

    public static void main(String[] args) {
        System.out.println(findNthNumber(2, 5));
    }

    public static int findNthNumber(int base, int power) {
        if (power == 0) return 1;
        return base * findNthNumber(base, power - 1);
    }
}
