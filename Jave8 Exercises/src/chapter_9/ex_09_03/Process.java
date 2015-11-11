package chapter_9.ex_09_03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Process {
    Logger logger = Logger.getLogger("");

    public void ｐrocess() throws Exception {
        try {
            File file = new File("c:¥¥tmp¥¥test.txt");
            FileReader filereader = new FileReader(file);

            Socket socket = new Socket("www.jp.FreeBSD.org", 80);
        } catch (FileNotFoundException | UnknownHostException ex) {
            logger.log(Level.SEVERE, "...", ex);
            throw ex;
        }
    }
}
