package netcracker.java.first;

import java.util.Comparator;

public class IncreaseComparator implements Comparator<Integer> {
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}
