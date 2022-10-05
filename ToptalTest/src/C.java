import java.util.HashMap;
import java.util.Map;

public class C {

    public static void main(String[] args) {
        //int[] a = {2, 1, 3};
        //int[] a = {2, 1, 4};
        int[] a = {0, 4, 3, -1};
        int s = 2;
        //int s = 3;
        System.out.println(c(a, s));
    }

    public static long c(int[] a, int S) {
        int threshold = 1000000000;
        int n = a.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int runningSum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            runningSum += a[i];
            final int key = runningSum - (S * (i + 1));
            res += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        if (res > threshold) {
            return threshold;
        } else {
            return res;
        }

    }
}
