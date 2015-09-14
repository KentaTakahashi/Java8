package chapter_6.ex_06_06;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class WordCheaker {

    public static void main(String args[]){

        ConcurrentHashMap<String, Set<File>> map = new ConcurrentHashMap<String, Set<File>>();

        List<File> files = new ArrayList<File>();
        String currentDir = new File("").getAbsolutePath();
        files.add(new File(currentDir + "\\src\\chapter_6\\ex_06_06\\Alice in Wonderland.txt"));
        files.add(new File(currentDir + "\\src\\chapter_6\\ex_06_06\\War and Peace.txt"));

        files.stream().parallel().forEach(file -> {
            try {
                String contents = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                List<String> words = Arrays.asList(contents.split("[\\P{L}}]+"));
                words.stream().forEach(word -> {
                    map.computeIfAbsent(word, key -> new HashSet<File>()).add(file);
                });
            } catch (Exception e) {
                e.printStackTrace();
            }

            });

        map.forEach((key, value)-> {
            System.out.println("key :" + key + "\t    value : " + value);
        });
    }
}
