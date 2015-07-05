package chapter_2.ex_02_12;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ShortWordCounter {

    public static void main(String args[]) throws IOException{

        String currentDir = new File("").getAbsolutePath();
        String contents = new String(Files.readAllBytes(
                Paths.get(currentDir + "\\src\\chapter_2\\ex_02_12\\Alice in Wonderland.txt")), StandardCharsets.UTF_8);
        Stream<String> words = Stream.of(contents.split("[\\P{L}}]+"));

        AtomicInteger[] shortWords = new AtomicInteger[13];
        for(int i = 0; i < shortWords.length; i++)
            shortWords[i] = new AtomicInteger();//init "0"

        words.parallel().forEach(s -> {
            if(s.length() < 12)
                shortWords[s.length()].addAndGet(1);
            else
                shortWords[12].addAndGet(1);//12文字以上もカウント
        });


        for(int i = 0; i < shortWords.length - 1; i++)
            System.out.println("word length = " + i + " \t:" + shortWords[i] + "\t count");

        System.out.println("word length   12over" + " \t:" + shortWords[12] + "\t count");
    }
}
