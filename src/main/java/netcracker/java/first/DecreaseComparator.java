package netcracker.java.first;

import java.util.Comparator;

public class DecreaseComparator implements Comparator<Integer> {
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}