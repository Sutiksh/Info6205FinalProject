package sort;

import util.Benchmark_Timer;
import util.FileUtil;

import java.io.IOException;
import java.util.*;
import java.util.function.Supplier;

public class Unicode {

    public void sort(List<String> words){
        try {
//            String[] hindiArr = {"गुणवत्ता", "एशिया", "खाना", "पकाना", "फोटोग्राफी", "भारतीय", "मसाला", "विध"};
//            words.stream().sorted().forEach(System.out::println);
            List<String> test = new ArrayList<>();
            for(int i=0; i<words.size(); i++){
                byte[] bytearr = words.get(i).getBytes("UTF-16");
                test.add(new String(bytearr, "UTF-16"));
            }

//             String encodedString = MimeUtility.encodeText(test, "utf-16", "B");
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
        List<String> words = FileUtil.hindiWordsList("Unicode/res/extendedHindiWords.csv");

        Supplier<List<String>> supplier = () -> {
           Collections.shuffle(words);
            return words;
        };

        Benchmark_Timer<List<String>> bTimer = new Benchmark_Timer<>("Benchmark Test", null, (x) -> unicode.sort(words), null);

        double time = bTimer.runFromSupplier(supplier, 10);
        System.out.println(" Order Situation- Randomly Ordered" + " Time Taken: " + time + "ms");

    }
}
