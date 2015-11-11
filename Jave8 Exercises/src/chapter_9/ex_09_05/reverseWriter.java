package chapter_9.ex_09_05;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class reverseWriter {

    public static void main(String args[]) throws IOException{
        String currentDir = new File("").getAbsolutePath();
        Path in  = Paths.get(currentDir + "\\src\\chapter_9\\ex_09_05\\Alice in Wonderland.txt");
        Path out = Paths.get(currentDir + "\\src\\chapter_9\\ex_09_05\\Alice in Wonderland reverse.txt");

        byte[] readBytes  = Files.readAllBytes(in);
        int length = readBytes.length;
        byte[] writeBytes = new byte[length];

        for(int i = 0; i < length; i++)
            writeBytes[i] = readBytes[length - i - 1];

        Files.write(out, writeBytes);
    }
}
