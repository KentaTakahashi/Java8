package chapter_2.ex_02_02;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilterTest {

    public static void main(String args[]) throws IOException{

        String currentDir = new File("").getAbsolutePath();
        String contents = new String(Files.readAllBytes(
                Paths.get(currentDir + "\\src\\chapter_2\\ex_02_02\\Alice in Wonderland.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}}]+"));



        System.out.println("\n-----paraller Stream-----");
        Stream<String> longWords = words.parallelStream().filter(w -> {
            if(w.length() > 12) {
                System.out.println("called filter method");
                return true;
            } else {
                return false;
            }

        }).limit(5);

        longWords.forEach(System.out::println);



        System.out.println("\n-----normal Stream-----");
        Stream<String> longWords2 = words.stream().filter(w -> {
            if(w.length() > 12) {
                System.out.println("called filter method");
                return true;
            } else {
                return false;
            }

        }).limit(5);

        longWords2.forEach(System.out::println);
    }
}
