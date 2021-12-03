package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.FileUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static edu.neu.coe.info6205.util.Utilities.show;

public class Unicode {

    public void sort(List<String> words) {
        try {
            List<String> test = new ArrayList<>();
            for (String word : words) {
                byte[] bytearr = word.getBytes(StandardCharsets.UTF_16);
                test.add(new String(bytearr, StandardCharsets.UTF_16));
            }

            System.out.println("...Before Sorting...");
            for (String str : test) {
                System.out.println(str);
            }
            MSD.sort(test);

            System.out.println("\n...After Sorting...");
            for (String str : test) {
                System.out.println(str);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }


    public static void main(String[] args) throws IOException {
        Unicode unicode = new Unicode();
        List<String> words = FileUtil.hindiWordsList("extendedHindiWords.csv");
        Supplier<List<String>> supplier = () -> {
            Collections.shuffle(words);
            return words;
        };
        String[] sortInput = words.toArray(new String[0]);

        Benchmark_Timer<List<String>> bTimer = new Benchmark_Timer<>("Benchmark Test", null, (x) -> unicode.sort(words), null);
        double time = bTimer.runFromSupplier(supplier, 10);
        System.out.println("MSD Radix Sort - Order Situation- Randomly Ordered" + " Time Taken: " + time + "ms");

        Consumer<List<String>> quickDualPivotConsumer = (x) -> QuickDualPivot.sort(sortInput);
        computeBenchMark(supplier, sortInput, quickDualPivotConsumer, "QuickDualPivot" + "- Randomly Ordered");

        TimSort timSort = new TimSort();
        Consumer<List<String>> listConsumer = (x) -> timSort.sort(sortInput, 0, sortInput.length);
        computeBenchMark(supplier, sortInput, listConsumer, "TimSort" + "- Randomly Ordered");
    }

    private static void computeBenchMark(Supplier<List<String>> supplier, String[] sortInput, Consumer listConsumer, String description) {
        Benchmark_Timer<List<String>> benchmarkTimer = new Benchmark_Timer<>("Benchmark Test", null, listConsumer, null);
        double sortTime = benchmarkTimer.runFromSupplier(supplier, 100);
        show(sortInput, description);
        System.out.println(description  + " Time Taken: " + sortTime + "ms");
    }
}
