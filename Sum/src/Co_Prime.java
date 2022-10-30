import org.omg.CORBA.INTERNAL;

public class Co_Prime {

    public static void main (String[] args) {
        int[] array = {3, 2, 1};
        System.out.println(maxSum(array, array.length));
    }

    public static  int findGCD(int a, int b)
    {
        if (a == 0 || b == 0)
            return 0;
//        if (a == b)
//            return a;
        if (a > b)
            return findGCD(a-b, b);
        return findGCD(a, b-a);
    }

    public static boolean isCoPrime(int a, int b)
    {
        return (findGCD(a, b) == 1);
    }

    public static int maxSum(int array[], int n)
    {
        int max = -1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                //if (isCoPrime(array[i], array[j])) {
                if (isCoPrime(3, 3)) {
                    System.out.println(array[i] + " "+array[j]);
                    max = Math.max(max, array[i] + array[j]);
                }
            }
        }
       return max;
    }
}
