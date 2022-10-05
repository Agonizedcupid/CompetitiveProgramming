import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class B {
    public static void main(String[] args) {
        int[] A = {2, 1, 1, 3, 2, 1, 1, 3};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {

        HashSet<Integer> hash = new HashSet<>();
        for (int i=0; i<A.length; i++) {
            hash.add(A[i]);
        }

        return hash.size();

//        //HashSet<Integer> hashSet = new HashSet<>();
//        List<Integer> hashSet = new ArrayList<>();
//        for (int i = 0; i < A.length; i++) {
//            if (hashSet.contains(A[i])) {
//                //remove
//                //System.out.println(hashSet.size());
//                //hashSet.remove(A[i]);
//            } else {
//                hashSet.add(A[i]);
//            }
//        }
//
//        return hashSet.size();
    }


//    public static int b(int[] A) {
//        int n = A.length;
//        HashSet<Integer> hashSet = new HashSet<>();
//        int max_count = 1;
//        int i = 0;
//        int j = 0;
//        int result = 0;
//
//        while (i < n) {
////            if (hashSet.contains(A[i])) {
////                hashSet.add(A[i] = A[i] + 1);
////            } else {
////                hashSet.add(A[i] = 1);
////            }
////
////            if (hashSet.size() == max_count) {
////                result = Math.min(result, i-j);
////            }
////
////            while (hashSet.size() == max_count && j<=i) {
////                hashSet.add(A[j] = A[j] - 1);
////                if hashSet.contains(A[j] == 0] == 0 {
////
////                }
////                del hashSet[A[j]]
////                j+=1
////                if len(hashSet) < max_count:
////                break
////                        result = min(result, i-j)
////
////                if result == max_count:
////                return result
////                j+=1
////                i+=1
////            }
//
//        }
//    }
}
