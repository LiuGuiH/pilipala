package test;/*
package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadTest {
    public static void main(String[] args) {
        FileReader fr;
        ArrayList<String> words = new ArrayList<>();
        try {
            fr = new FileReader("F:\\IdeaJavaWeb\\pilipala\\src\\CensorWords.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = "dsfsdfsdfs让他bitch而法国v色法国";
        for (String s : words) {
            value = value.replace(s, "**");
        }
        System.out.println(value);
    }

}
*/
