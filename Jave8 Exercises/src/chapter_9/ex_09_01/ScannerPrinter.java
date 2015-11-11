package chapter_9.ex_09_01;

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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (Exception e) {
                ;
            }
        }
    }
}
