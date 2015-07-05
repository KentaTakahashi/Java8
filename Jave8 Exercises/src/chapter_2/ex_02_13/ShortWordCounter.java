package chapter_2.ex_02_13;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShortWordCounter {

    public static void main(String args[]) throws IOException{

        String currentDir = new File("").getAbsolutePath();
        String contents = new String(Files.readAllBytes(
                Paths.get(currentDir + "\\src\\chapter_2\\ex_02_13\\Alice in Wonderland.txt")), StandardCharsets.UTF_8);
        Stream<String> words = Stream.of(contents.split("[\\P{L}}]+"));

        Map<Integer, List<String>> res = words.parallel().collect(Collectors.groupingBy(String::length));

        //文字数別にソートした文字列の表示
        for(int i = 0; i < 12; i++)
            for(String s: res.get(i))
                System.out.println(s);

        //各文字数の単語の総和を表示
        for(int i = 0; i < 12; i++)
            System.out.println("word length = " + i + " \t:" + res.get(i).size() + "\t count");

    }
}
