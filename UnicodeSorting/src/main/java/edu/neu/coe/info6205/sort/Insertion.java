package edu.neu.coe.info6205.sort;

import java.util.List;

public class Insertion {
    public static void sort(String[] a, int lo, int hi, int d) { // Sort from a[lo] to a[hi], starting at the dth
        // character.
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--)
                exch(a, j, j - 1);
    }

    private static boolean less(String v, String w, int d) {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }

    public static void exch(String[] a, int i, int j) {
        String tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
