package sort;

import util.FileUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Unicode {
    public static void main(String[] args) {
        try {
//            String[] hindiArr = {"गुणवत्ता", "एशिया", "खाना", "पकाना", "फोटोग्राफी", "भारतीय", "मसाला", "विध"};
            List<String> words = FileUtil.hindiWordsList("Unicode/res/hindiChar.csv");
            words.stream().sorted().forEach(System.out::println);
            List<String> test = new ArrayList<>();
            for(int i=0; i<words.size(); i++){
                byte[] bytearr = words.get(i).getBytes("UTF-16");
                test.add(new String(bytearr, "UTF-16"));
            }

//             String encodedString = MimeUtility.encodeText(test, "utf-16", "B");
//            System.out.println("...Before Sorting...");
//            for(String str: test){
//                System.out.println(str);
//            }
//            MSD.sort(test);
//
//            System.out.println("\n...After Sorting...");
//            for(String str: test){
//                System.out.println(str);
//            }
        } catch (Exception e){
            System.out.println("Error: " + e);
        }

    }
}
