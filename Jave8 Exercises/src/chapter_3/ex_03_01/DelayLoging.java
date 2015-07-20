package chapter_3.ex_03_01;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DelayLoging {

    public static void LogIf(Level level, Supplier<Boolean> tester, Supplier<String> massage) {
        Logger logger = Logger.getLogger("test");
        if(tester.get())
            if(logger.isLoggable(level))
                logger.info(massage.get());
    }



    public static void main(String args[]) {
        Logger logger = Logger.getLogger("test");
        logger.setLevel(Level.FINEST);


        String[] a ={"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};

        for(int j = 0; j < a.length; j++) {
            a[j] = a[j].toUpperCase();
            int i = j;
            LogIf(Level.FINEST, () -> i == 10, () -> "a[10] = " + a[10]);
        }
    }
}
