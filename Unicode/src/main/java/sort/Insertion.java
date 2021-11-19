package sort;

import java.util.List;

public class Insertion {
    public static void sort(List<String> a, int lo, int hi, int d) { // Sort from a[lo] to a[hi], starting at the dth
        // character.
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a.get(j), a.get(j - 1), d); j--)
                exch(a, j, j - 1);
    }

    private static boolean less(String v, String w, int d) {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }

    public static void exch(List<String> a, int i, int j) {
        String tmp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
    }
}
