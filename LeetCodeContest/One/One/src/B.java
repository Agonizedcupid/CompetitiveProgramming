import java.util.HashSet;
import java.util.Set;

public class B {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        System.out.println(maxCount(array, 8, 1));
    }

    public static int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> check = new HashSet<>();
        for (Integer index : banned) {
            check.add(index);
        }
        int count = 0;
        int sum = 0;
        for (int index = 1; index <= n; index++) {
            if (!check.contains(index)) {
                if (sum <= maxSum) {
                    sum += index;
                    if (sum <= maxSum) {
                        count++;
                    }
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
