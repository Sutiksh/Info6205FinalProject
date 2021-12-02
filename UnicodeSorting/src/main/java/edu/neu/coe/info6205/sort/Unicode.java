package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.FileUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

        Benchmark_Timer<List<String>> bTimer = new Benchmark_Timer<>("Benchmark Test", null, (x) -> unicode.sort(words), null);
        double time = bTimer.runFromSupplier(supplier, 10);
        System.out.println("MSD Radix Sort - Order Situation- Randomly Ordered" + " Time Taken: " + time + "ms");

        String[] sortInput = words.toArray(new String[0]);
        QuickDualPivot quickDualPivot = new QuickDualPivot();
        Benchmark_Timer<List<String>> bTimerDualPivotQuick = new Benchmark_Timer<>("Benchmark Test", null, (x) -> QuickDualPivot.sort(sortInput), null);
        double time1 = bTimerDualPivotQuick.runFromSupplier(supplier, 100);
       // show(sortInput, "QuickDualPivot");
        System.out.println("Dual Pivot QuickSort - Order Situation - Randomly Ordered" + " Time Taken: " + time1 + "ms");

        TimSort timSort = new TimSort();
        Benchmark_Timer<List<String>> timSortTimer = new Benchmark_Timer<>("Benchmark Test", null, (x) -> timSort.sort(sortInput, 0, sortInput.length), null);
        double timSortTime = timSortTimer.runFromSupplier(supplier, 100);
        show(sortInput, "TimSort");
        System.out.println("TimSort - Randomly Ordered" + " Time Taken: " + timSortTime + "ms");
    }
}
