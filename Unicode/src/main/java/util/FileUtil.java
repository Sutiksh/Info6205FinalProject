package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<String> hindiWordsList(String fileName) throws IOException {
        List<String> hindiWords = new ArrayList<>();
        FileReader fr = new FileReader(fileName);

        try (BufferedReader br = new BufferedReader(fr)) {

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
