package chapter_2.ex_02_03;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParallelFor {

    public static void main(String args[]) throws IOException{
        long startTime;
        long endTime;

        String currentDir = new File("").getAbsolutePath();

        /***** Test 1 "Alice in Wonderland" *****/
        String contents = new String(Files.readAllBytes(
                Paths.get(currentDir + "\\src\\chapter_2\\ex_02_03\\Alice in Wonderland.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}}]+"));

        System.out.println("\"Alice in Wonderland\"  total words = " + words.size());

        //Normal Stream
        startTime = System.nanoTime();
        for(int i = 0; i < 1000; i++)
            words.stream().filter(w -> w.length() > 12).count();
        endTime = System.nanoTime();
        System.out.println("Normal Stream\t" + (endTime - startTime) / 1000 + " (nanoseconds)");

        //Parallel Stream
        startTime = System.nanoTime();
        for(int i = 0; i < 1000; i++)
            words.parallelStream().filter(w -> w.length() > 12).count();
        endTime = System.nanoTime();
        System.out.println("Parallel Stream\t" + (endTime - startTime) / 1000 + " (nanoseconds)");





        /***** Test 2 "War and Peace" *****/
        String contents2 = new String(Files.readAllBytes(
                Paths.get(currentDir + "\\src\\chapter_2\\ex_02_03\\War and Peace.txt")), StandardCharsets.UTF_8);
        List<String> words2 = Arrays.asList(contents2.split("[\\P{L}}]+"));

        System.out.println("\n\"War and Peace\"  total words = " + words2.size());

        //Normal Stream
        startTime = System.nanoTime();
        for(int i = 0; i < 1000; i++)
            words2.stream().filter(w -> w.length() > 12).count();
        endTime = System.nanoTime();
        System.out.println("Normal Stream\t" + (endTime - startTime) / 1000 + " (nanoseconds)");

        //Parallel Stream
        startTime = System.nanoTime();
        for(int i = 0; i < 1000; i++)
            words2.parallelStream().filter(w -> w.length() > 12).count();
        endTime = System.nanoTime();
        System.out.println("Parallel Stream\t" + (endTime - startTime) / 1000 + " (nanoseconds)");



        /***** Test 3 "War and Peace" x 10 *****/
        List<String> words3 = new ArrayList<>();
        for(int i = 0; i < 10; i++)
            words3.addAll(words2);

        System.out.println("\n\"War and Peace\" x 10  total words = " + words3.size());

        //Normal Stream
        startTime = System.nanoTime();
        for(int i = 0; i < 100; i++)
            words3.stream().filter(w -> w.length() > 12).count();
        endTime = System.nanoTime();
        System.out.println("Normal Stream\t" + (endTime - startTime) / 100 + " (nanoseconds)");

        //Parallel Stream
        startTime = System.nanoTime();
        for(int i = 0; i < 100; i++)
            words3.parallelStream().filter(w -> w.length() > 12).count();
        endTime = System.nanoTime();
        System.out.println("Parallel Stream\t" + (endTime - startTime) / 100 + " (nanoseconds)");



        /***** Test 4 "War and Peace" x 100 *****/
        List<String> words4 = new ArrayList<>();
        for(int i = 0; i < 100; i++)
            words4.addAll(words2);

        System.out.println("\n\"War and Peace\" x 100  total words = " + words4.size());

        //Normal Stream
        startTime = System.nanoTime();
        for(int i = 0; i < 10; i++)
            words4.stream().filter(w -> w.length() > 12).count();
        endTime = System.nanoTime();
        System.out.println("Normal Stream\t" + (endTime - startTime) / 10 + " (nanoseconds)");

        //Parallel Stream
        startTime = System.nanoTime();
        for(int i = 0; i < 10; i++)
            words4.parallelStream().filter(w -> w.length() > 12).count();
        endTime = System.nanoTime();
        System.out.println("Parallel Stream\t" + (endTime - startTime) / 10 + " (nanoseconds)");

    }
}
