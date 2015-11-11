package chapter_9.ex_09_04;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilesWalk{

    public static void main(String args[]) throws IOException {
        Stream<Path> pathStream = Files.walk(new File(".\\tmp").toPath());
        pathStream.forEachOrdered(path -> {
            try {
                String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
                List<String> words = Arrays.asList(contents.split("[\\P{L}}]+"));

                if(words.contains("transient") && words.contains("volatile"))
                    System.out.println(path);
            } catch (IOException e) {
                //e.printStackTrace();
            } catch (OutOfMemoryError e) {
                //e.printStackTrace();
            }
        });
        pathStream.close();
    }
}
