package chapter_8.ex_08_05;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

public class LongWordCounter {

    public static void main(String args[]) throws IOException{

        String currentDir = new File("").getAbsolutePath();
        String contents = new String(Files.readAllBytes(
                Paths.get(currentDir + "\\src\\chapter_8\\ex_08_05\\Alice in Wonderland.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}}]+"));

        LongAdder count = new LongAdder();
        words.forEach(w -> {
            if(w.length() > 12) count.increment();;
        });

        System.out.println("Count = " + count);

    }
}
