/*
  (c) Copyright 2018, 2019 Phasmid Software
 */
package sort.simple;

import sort.helper.BaseHelper;
import sort.helper.Helper;
import sort.helper.SortWithHelper;
import util.Config;

public class SelectionSort<X extends Comparable<X>> extends SortWithHelper<X> {

    /**
     * Constructor for SelectionSort
     *
     * @param N      the number elements we expect to sort.
     * @param config the configuration.
     */
    public SelectionSort(int N, Config config) {
        super(DESCRIPTION, N, config);
    }

    public SelectionSort() {
        this(new BaseHelper<>(DESCRIPTION));
    }

    /**
     * Constructor for SelectionSort
     *
     * @param helper an explicit instance of Helper to be used.
     */
    public SelectionSort(Helper<X> helper) {
        super(helper);
    }

    public void sort(X[] xs, int from, int to) {
        final Helper<X> helper = getHelper();
        // TO BE IMPLEMENTED
     }

    /**
     * This is used by unit tests.
     *
     * @param ys  the array to be sorted.
     * @param <Y> the underlying element type.
     */
    public static <Y extends Comparable<Y>> void mutatingSelectionSort(Y[] ys) {
        new SelectionSort<Y>().mutatingSort(ys);
    }

    public static final String DESCRIPTION = "Selection sort";

}
