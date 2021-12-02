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

    public void MSDSort(List<String> words) {
        try {
            List<String> test = new ArrayList<>();
            for(int i=0; i<words.size(); i++){
                byte[] bytearr = words.get(i).getBytes("UTF-8");
                test.add(new String(bytearr, "UTF-8"));
            }

            System.out.println("MSD sort started...");
            MSD.sort(test);
            System.out.println("MSD sort started...Done!");


        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void LSDSort(List<String> words){
        try {
            List<String> test = new ArrayList<>();
            for(int i=0; i<words.size(); i++){
                byte[] bytearr = words.get(i).getBytes("UTF-8");
                test.add(new String(bytearr, "UTF-8"));
            }
            System.out.println("LSD sort started...");
            LSDStringSort.sort(test);
            System.out.println("LSD sort started...Done!");


        } catch (Exception e){
            System.out.println("Error: " + e);
        }
    }


    public static void main(String[] args) throws IOException {
        Unicode unicode = new Unicode();
        List<String> words = FileUtil.hindiWordsList("UnicodeSorting/src/main/resources/extendedHindiWords.csv");
        Supplier<List<String>> supplier = () -> {
            Collections.shuffle(words);
            return words;
        };
        String[] sortInput = words.toArray(new String[0]);

        Benchmark_Timer<List<String>> bTimer = new Benchmark_Timer<>("Benchmark Test", null, (x) -> unicode.MSDSort(words), null);
        double time = bTimer.runFromSupplier(supplier, 10);
        System.out.println("MSD Radix Sort - Order Situation- Randomly Ordered" + " Time Taken: " + time + "ms");

        Consumer<List<String>> quickDualPivotConsumer = (x) -> QuickDualPivot.sort(sortInput);
        computeBenchMark(supplier, sortInput, quickDualPivotConsumer, "QuickDualPivot" + "- Randomly Ordered");

        Consumer<List<String>> listConsumer = (x) -> TimSort.sort(sortInput, 0, sortInput.length);
        computeBenchMark(supplier, sortInput, listConsumer, "TimSort" + "- Randomly Ordered");

        Benchmark_Timer<List<String>> lbTimer = new Benchmark_Timer<>("Benchmark Test", null, (x) -> unicode.LSDSort(words), null);
        double lsdtime = lbTimer.runFromSupplier(supplier, 10);
        System.out.println(" Order Situation- Randomly Ordered for LSD" + " Time Taken: " + lsdtime + "ms");
    }

    private static void computeBenchMark(Supplier<List<String>> supplier, String[] sortInput, Consumer listConsumer, String description) {
        Benchmark_Timer<List<String>> benchmarkTimer = new Benchmark_Timer<>("Benchmark Test", null, listConsumer, null);
        double sortTime = benchmarkTimer.runFromSupplier(supplier, 100);
        show(sortInput, description);
        System.out.println(description  + " Time Taken: " + sortTime + "ms");
    }
}
