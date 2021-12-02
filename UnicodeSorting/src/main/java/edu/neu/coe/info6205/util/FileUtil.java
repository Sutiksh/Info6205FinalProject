package edu.neu.coe.info6205.util;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<String> hindiWordsList(String fileName) throws IOException {
        ClassLoader classLoader = FileUtil.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream(fileName);

        List<String> hindiWords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream))) {

            String line = br.readLine();

            while(line != null) {
                hindiWords.add(line);
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return hindiWords;
    }

}
