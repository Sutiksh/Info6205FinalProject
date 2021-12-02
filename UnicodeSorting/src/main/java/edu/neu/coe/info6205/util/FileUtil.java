package edu.neu.coe.info6205.util;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileUtil {

    public static List<String> hindiWordsList(String fileName) throws FileNotFoundException {
        List<String> hindiWords = new ArrayList<>();
        FileReader fr = new FileReader(fileName);

        try (BufferedReader br = new BufferedReader(fr)) {

            String line = br.readLine();

            while(line != null) {
//                System.out.println(line);
//                String[] names = line.split(",");
//                String word = extractName(names);
                hindiWords.add(line);
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return hindiWords;
    }

}
