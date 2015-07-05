package chapter_2.ex_02_03;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ParallelFor {

    public static void main(String args[]) throws IOException{

        String currentDir = new File("").getAbsolutePath();
        String contents = new String(Files.readAllBytes(
                Paths.get(currentDir + "\\src\\chapter_2\\ex_02_03\\Alice in Wonderland.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}}]+"));


        //Normal Stream
        long startTime = System.nanoTime();
        words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println("Normal Stream\t" + (System.nanoTime() - startTime) + " (nanoseconds)");

        //Parallel Stream
        startTime = System.nanoTime();
        words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println("Parallel Stream\t" + (System.nanoTime() - startTime) + " (nanoseconds)");


    }
}
