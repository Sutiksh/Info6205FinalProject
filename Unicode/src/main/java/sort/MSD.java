package sort;

import java.util.List;

public class MSD {

    private static int R = 2560; // radix
    private static final int M = 15; // cutoff for small subarrays
    private static String[] aux; // auxiliary array for distribution

    private static int charAt(String s, int d) {
        if (d < s.length())
            return s.charAt(d);
        else
            return -1;
    }

    public static void sort(List<String> a) {
        int N = a.size();
        aux = new String[N];
        sort(a, 0, N - 1, 0);
    }

    private static void sort(List<String> a, int lo, int hi, int d) { // Sort from a[lo] to a[hi], starting at the dth
        // character.
        if (hi <= lo + M) {
            Insertion.sort(a, lo, hi, d);
            return;
        }
        int[] count = new int[R + 2]; // Compute frequency counts.

        for (int i = lo; i <= hi; i++) {
            count[charAt(a.get(i), d) + 2]++;
        }
        for (int r = 0; r < R + 1; r++) {
            count[r + 1] += count[r];
        } // Transform counts to indices.
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a.get(i), d) + 1]++] = a.get(i);
        } // Distribute.
        for (int i = lo; i <= hi; i++) {
            a.set(i, aux[i - lo]);
        } // Copy back.
        // Recursively sort for each character value.
        for (int r = 0; r < R; r++) {
            sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
        }
    }
}
