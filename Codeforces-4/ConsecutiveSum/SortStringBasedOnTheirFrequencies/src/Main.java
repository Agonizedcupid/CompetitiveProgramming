import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        //String result = sortChar("Eett");
        sortChar("Eett");
        //System.out.println(result);
    }

    public static void sortChar(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : word.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());

        while (!maxHeap.isEmpty()) {
            char current = maxHeap.remove();
            System.out.println(current + " : "+map.get(current));
        }
    }
}