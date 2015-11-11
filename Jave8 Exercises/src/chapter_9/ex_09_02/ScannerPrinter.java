package chapter_9.ex_09_02;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Scanner;

public class ScannerPrinter {

    public void copy(Path input, String output) {
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(input);
            out = new PrintWriter(output);
            while(in.hasNext())
                out.println(in.next().toLowerCase());
        } catch (IOException ex) {
            Throwable[] secondaryExceptions = ex.getSuppressed();
        }
    }
}
