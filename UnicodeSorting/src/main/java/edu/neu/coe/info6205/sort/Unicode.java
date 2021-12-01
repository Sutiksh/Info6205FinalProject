package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.FileUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Unicode {

    public void sort(List<String> words) {
        try {
//            String[] hindiArr = {"गुणवत्ता", "एशिया", "खाना", "पकाना", "फोटोग्राफी", "भारतीय", "मसाला", "विध"};
//            words.stream().sorted().forEach(System.out::println);
            List<String> test = new ArrayList<>();
            for (String word : words) {
                byte[] bytearr = word.getBytes(StandardCharsets.UTF_16);
                test.add(new String(bytearr, StandardCharsets.UTF_16));
            }

//             String encodedString = MimeUtility.encodeText(test, "utf-16", "B");
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
        List<String> words = FileUtil.hindiWordsList("Unicode/res/extendedHindiWords.csv");
        String[] arr = new String[words.size()];

        Supplier<List<String>> supplier = () -> {
            Random random = new Random();
            for (int k = 0; k < words.size(); k++) {
                arr[k] = words.get(random.nextInt(words.size()));
            }

            return Arrays.asList(arr);
        };

        Benchmark_Timer<List<String>> bTimer = new Benchmark_Timer<>("Benchmark Test", null, (x) -> unicode.sort(Arrays.asList(arr)), null);

        double time = bTimer.runFromSupplier(supplier, 10);
        System.out.println(" Order Situation- Randomly Ordered" + " Time Taken: " + time + "ms");


    }
}
