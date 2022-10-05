import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class A {

    public static void main(String[] args) {
        String[] T = {
                "codility1",
                "codility3",
                "codility2",
                "codility4b",
                "codility4a"
        };
        String[] R = {
                "Wrong answer",
                "OK",
                "OK",
                "Runtime error",
                "OK"
        };
        System.out.println(findScore(T, R));

    }

    public static int findScore(String[] T, String[] R) {
        T = rTName(T);
        Dummy[] testCases = modifying(T, R);
        int numberOfGroups = Arrays.stream(testCases).sorted(Comparator.comparing(d -> d.group)).collect(Collectors.toList()).get(testCases.length-1).group;
        int totalPassed = 0;
        for (int i = 1; i < numberOfGroups; i++) {
            int finalI = i;
            if (Arrays.stream(testCases).noneMatch(t -> t.group == finalI && !t.result.equals("OK"))) {
                totalPassed++;
            }
        }
        return totalPassed * 100 / numberOfGroups;
    }

    private static String[] rTName(String[] T) {
        String taskName = "";
        for (int i = 0; i < T[0].length(); i++) {
            if (T[0].charAt(i) == T[1].charAt(i) && !Character.isDigit(T[0].charAt(i))) {
                taskName += T[0].charAt(i);
            } else {
                break;
            }
        }
        for (int i = 0; i < T.length; i++) {
            T[i] = T[i].substring(taskName.length());
        }
        return T;
    }

    private static Dummy[] modifying(String[] T, String[] R) {
        Dummy[] testCases = new Dummy[T.length];
        for (int i = 0; i < T.length; i++) {
            testCases[i] = new Dummy();
            if (T[i].length() > 1 && !Character.isDigit(T[i].charAt(T[i].length() - 1))) {
                testCases[i].extension = T[i].charAt(T[i].length() - 1);
                testCases[i].group = Integer.parseInt(T[i].substring(0, T[i].length() - 1));
            } else {
                testCases[i].group = Integer.parseInt(T[i]);
            }
            testCases[i].result = R[i];
        }
        return testCases;
    }

    static class Dummy {
        public int group;
        char extension;
        String result;
    }
}
