package sort;

import sort.radix.LSDStringSort;
import sort.radix.MSD;
import util.Benchmark_Timer;
import util.FileUtil;

import java.io.IOException;
import java.util.*;
import java.util.function.Supplier;

public class Unicode {

    public void MSDSort(List<String> words){
        try {
//            String[] hindiArr = {"गुणवत्ता", "एशिया", "खाना", "पकाना", "फोटोग्राफी", "भारतीय", "मसाला", "विध"};
            List<String> test = new ArrayList<>();
            for(int i=0; i<words.size(); i++){
                byte[] bytearr = words.get(i).getBytes("UTF-8");
                test.add(new String(bytearr, "UTF-8"));
            }

//            System.out.println("...Before Sorting...");
//            for(String str: test){
//                System.out.println(str);
//            }
            System.out.println("MSD sort started...");
            MSD.sort(test);
            System.out.println("MSD sort started...Done!");

//            System.out.println("\n...After Sorting...");
//            for(String str: test){
//                System.out.println(str);
//            }
        } catch (Exception e){
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
        List<String> words = FileUtil.hindiWordsList("Unicode/res/modfixedwords.csv");

        Supplier<List<String>> supplier = () -> {
            Collections.shuffle(words);
            return words;
        };

        Benchmark_Timer<List<String>> mbTimer = new Benchmark_Timer<>("Benchmark Test", null, (x) -> unicode.MSDSort(words), null);
        Benchmark_Timer<List<String>> lbTimer = new Benchmark_Timer<>("Benchmark Test", null, (x) -> unicode.LSDSort(words), null);

        double msdtime = mbTimer.runFromSupplier(supplier, 10);
        double lsdtime = lbTimer.runFromSupplier(supplier, 10);
        System.out.println(" Order Situation- Randomly Ordered for MSD" + " Time Taken: " + msdtime + "ms");
        System.out.println(" Order Situation- Randomly Ordered for LSD" + " Time Taken: " + lsdtime + "ms");






    }
}
