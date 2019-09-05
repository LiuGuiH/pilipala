package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordUtil {
    public static List<String> readTxt(){
        FileReader fr;
        List<String> words = new ArrayList<>();
        try {
            fr = new FileReader("C:\\Users\\刘桂华\\IdeaMavenProjects\\pilipala\\src\\CensorWords.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}
