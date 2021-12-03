package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.FileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static edu.neu.coe.info6205.util.Utilities.show;

public class Unicode {

    public static void main(String[] args) throws IOException {
        List<String> words = FileUtil.hindiWordsList("UnicodeSorting/src/main/resources/extendedHindiWords.csv");
        Supplier<List<String>> supplier = () -> {
            Collections.shuffle(words);
            return words;
        };
        String[] sortInput = words.toArray(new String[0]);

        //MSDStringSort Benchmark
        Consumer<List<String>> msdSort = (x) -> MSD.sort(sortInput);
        computeBenchMark(supplier, sortInput, msdSort, "MSDStringSort" + "- Randomly Ordered");
        //Dual Pivot Quick Sort Benchmark
        Consumer<List<String>> quickDualPivotConsumer = (x) -> QuickDualPivot.sort(sortInput);
        computeBenchMark(supplier, sortInput, quickDualPivotConsumer, "QuickDualPivot" + "- Randomly Ordered");

        //Tim Sort Benchmark
        TimSort timSort = new TimSort();
        Consumer<List<String>> listConsumer = (x) -> timSort.sort(sortInput, 0, sortInput.length);
        computeBenchMark(supplier, sortInput, listConsumer, "TimSort" + "- Randomly Ordered");

        //LSDStringSort Timer
        Consumer<List<String>> lsdTimer = (x) -> LSDStringSort.sort(sortInput);
        computeBenchMark(supplier, sortInput, lsdTimer, "LSDStringSort" + "- Randomly Ordered");
    }

    private static void computeBenchMark(Supplier<List<String>> supplier, String[] sortInput, Consumer listConsumer, String description) {
        Benchmark_Timer<List<String>> benchmarkTimer = new Benchmark_Timer<>("Benchmark Test", null, listConsumer, null);
        double sortTime = benchmarkTimer.runFromSupplier(supplier, 100);
        show(sortInput, description);
        System.out.println(description + " Time Taken: " + sortTime + "ms");
    }
}
