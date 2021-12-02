package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.FileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class Unicode {

    public void sort(List<String> words){
        try {
            List<String> test = new ArrayList<>();
            for(int i=0; i<words.size(); i++){
                byte[] bytearr = words.get(i).getBytes("UTF-16");
                test.add(new String(bytearr, "UTF-16"));
            }


            System.out.println("...Before Sorting...");
            for(String str: test){
                System.out.println(str);
            }
            MSD.sort(test);

            System.out.println("\n...After Sorting...");
            for(String str: test){
                System.out.println(str);
            }
        } catch (Exception e){
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

        String[] dualPivotInput = words.toArray(new String[0]);
        QuickDualPivot quickDualPivot =  new QuickDualPivot();
        Benchmark_Timer<List<String>> bTimerDualPivotQuick = new Benchmark_Timer<>("Benchmark Test", null, (x) -> quickDualPivot.sort(dualPivotInput), null);

        double time1 = bTimerDualPivotQuick.runFromSupplier(supplier, 100);
        quickDualPivot.show(dualPivotInput);
        System.out.println(" Dual Pivot QuickSort - Order Situation - Randomly Ordered" + " Time Taken: " + time1 + "ms");
    }
}
