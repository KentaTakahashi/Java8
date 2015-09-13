package chapter_6.ex_06_01;

import java.util.concurrent.atomic.AtomicReference;

public class LongestString {
    private static AtomicReference<String> longest = new AtomicReference<String>("");;

    public static String update(String observed) {
        return longest.updateAndGet(x -> {
            if(x.length() < observed.length())
                return observed;
            else
                return x;
        });
    }
}
