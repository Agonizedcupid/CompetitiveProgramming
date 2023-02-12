import java.util.ArrayList;
import java.util.List;

public class MyHashSet {

    //Length of the bucket for HashFunction:
    private final int BUCKETS = 1000;
    private List<Integer>[] set;

    //For HashFunction Equation: Y = key % BUCKET
    public int generateIndex(int key) {
        return key % BUCKETS;
    }

    public int getPosition(int key, int index) {
        //As each bucket contain a list
        List<Integer> temp = set[index];

        if (temp == null) return -1;

        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i) == key) return i;
        }

        return -1;

    }

    public MyHashSet() { // Constructor
        set = (List<Integer>[]) new ArrayList[BUCKETS];
    }

    public void add(int key) {
        int index = generateIndex(key);
        int position = getPosition(key, index);

        if (position < 0) { // it means that list is empty:
            if (set[index] == null) {
                set[index] = new ArrayList<>();
            }
        }
        set[index].add(key);
    }

    public boolean contains(int key) {
        return getPosition(generateIndex(key), key) >= 0;
    }

    public void remove(int key) {
        if (contains(key)) {
            set[generateIndex(key)].remove(key);
        }
    }

    public void printHashSet() {
        for (int i=0; i<set.length; i++) {
            System.out.print(set[i] + " ");
        }
    }
}
